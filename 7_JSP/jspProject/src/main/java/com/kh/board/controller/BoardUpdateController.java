package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardUpdateController
 */
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if(JakartaServletFileUpload.isMultipartContent(request)) {
			// 1. 파일 용량제한(byte)
			int fileMaxSize = 1024 * 1024 * 10; // 10 MB
			int requestMaxSize = 1024 * 1024 * 20; // 20MB
			
			// 2. 전달된 파일을 저장시킬 폴더경로 가져오기
			String savePath = request.getServletContext().getRealPath("/resources/board_upfile");

			// 3. DiskFileItemFactory(파일을 임시로 저장) 객체 생성
			DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
			
			// JakartaServletFileUpload - http요청으로 들어온 파일 데이터를 파싱 -> 개별 FileItem 객체로 변환
			/*
			 * ex) title : 안녕하세요  =>
			 * content : 반갑습니다    =>   개별 파싱
			 * author : user01      => 
			 */
			JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
			
			upload.setFileSizeMax(fileMaxSize);
			upload.setSizeMax(requestMaxSize);
			
			// 요청(request)으로부터 파일 아이템 파싱
			List<FileItem> formItems = upload.parseRequest(request);
			
			// 추가할 데이터
			Board b = new Board();
			Attachment at = null;
			String originFileNo = null;
			
			// 반복문을 통해 파일과 파라미터 정보 획득
			// isFormField => true면 일반 파라미터, false면 파일 데이터
			for(FileItem item : formItems) {
				System.out.println(item);
				if(item.isFormField()) { // 일반 파라미터
					switch(item.getFieldName()) {
					case "bno":
						b.setBoardNo(Integer.parseInt(item.getString(Charset.forName("UTF-8"))));
						break;
					case "category":
						b.setCategory(item.getString(Charset.forName("UTF-8")));
						break;
					case "title":
						b.setBoardTitle(item.getString(Charset.forName("UTF-8")));
						break;
					case "content":
						b.setBoardContent(item.getString(Charset.forName("UTF-8")));
						break;
					case "originFileNo":
						originFileNo = item.getString(Charset.forName("UTF-8"));
					}
				} else {
					String originName = item.getName(); // 업로드 요청한 파일명(오리지널 파일명)
					
					if(originName.length() > 0) { // 파일을 업로드 했을 때
						// 고유한 파일명 생성
						String tmpName = "boardFile_" + System.currentTimeMillis();
						String type = originName.substring(originName.lastIndexOf("."));
						String changeName = tmpName + type; // 서버에 저장할 파일명
						
						File f = new File(savePath, changeName);
						item.write(f.toPath()); // 저장한 경로에 파일 업로드
						
						at = new Attachment();
						at.setOriginName(originName);
						at.setChangeName(changeName);
						at.setFilePath("resources/board_upfile/"); // contextPath에도 슬래시가 있으니 빼고 저장
					}
				}
			}
			
			if(at != null) {
				// 기존 첨부파일이 있을때
				if(originFileNo != null) {
					at.setFileNo(Integer.parseInt(originFileNo));
				} else {
					at.setRefBoardNo(b.getBoardNo());
				}
			}
			
			int result = new BoardService().updateBoard(b,at);
			// 새로운 첨부파일 X					b, null -> board update
			// 새로운 첨부파일 O, 기존 첨부파일 O		b, fileNo -> board update, attachment update
			// 새로운 첨부파일 O, 기존 첨부파일 X		b, refBoardNo -> board update, attachment insert
			
			if(result > 0) { // 성공 -> 게시글 상세페이지(jspProject/detail.bo?bno=게시글번호)
				request.getSession().setAttribute("alertMsg", "일반게시글 수정 성공");
				response.sendRedirect(request.getContextPath() + "/detail.bo?bno="+b.getBoardNo());
			} else { // 실패 -> 업로드된 파일 삭제해주고 에러페이지
				if(at != null) {
					new File(savePath + at.getChangeName()).delete();
				}
				
				request.setAttribute("errorMsg", "일반게시글 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
