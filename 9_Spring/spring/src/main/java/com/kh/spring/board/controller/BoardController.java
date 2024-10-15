package com.kh.spring.board.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.board.service.BoardService;
import com.kh.spring.common.template.Template;
import com.kh.spring.common.vo.PageInfo;

@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("list.bo")
	public String selectList(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int boardCount = boardService.selectListCount();
		
		PageInfo pi = Template.getPageInfo(boardCount, currentPage, 10, 5);
		ArrayList<Board> list = boardService.selectList(pi);
		
		model.addAttribute("list",list);
		model.addAttribute("pi",pi);
		
		return "board/boardListView";
	}
	
	@RequestMapping("detail.bo")
	public String selectBoard(@RequestParam(value="bno") int boardNo, Model model) {
		int result = boardService.increaseCount(boardNo);
		
		if( result > 0 ) {
			Board board = boardService.selectBoard(boardNo);
			model.addAttribute("b", board);
			return "board/boardDetailView";
		} else {
			model.addAttribute("errorMsg","게시글 조회 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("enrollForm.bo")
	public String enrollForm() {
		return "board/boardEnrollForm";
	}
	
	@RequestMapping("insert.bo")
	public String insertBoard(Board b, MultipartFile upfile, HttpSession session, Model m) {
		System.out.println(b);
		System.out.println(upfile);
		String saveDir = "/resources/uploadFile/";
		
		// 전달된 파일이 있을 경우 -> 파일 이름 변경 -> 서버에 저장 -> 원본명, 서버업로드 경로를 b객체에 담기
		if(!upfile.getOriginalFilename().equals("")) {
			String changeName = Template.saveFile(upfile, session, saveDir);
			
			b.setChangeName(saveDir + changeName);
			b.setOriginName(upfile.getOriginalFilename());
		}
		
		int result = boardService.insertBoard(b);
		
		if(result > 0) { // 성공 > list페이지로 이동
			session.setAttribute("alertMsg", "게시글 작성 성공");
			return "redirect:list.bo";
		} else { // 실패  > 에러페이지
			m.addAttribute("errorMsg","게시글 작성 실패");
			return "common/errorPage";
		}
	}
	
	@PostMapping("updateForm.bo")
	public String updateForm(int bno, Model model) {
		model.addAttribute("b", boardService.selectBoard(bno));
		
		return "board/boardUpdateForm";
	}
	
	@PostMapping("update.bo")
	public String updateBoard(Board b, MultipartFile reupfile, HttpSession session, Model m) {
		// 새로운 첨부파일 있다면 저장 후 b 객체에 파일명 수정
		// b 객체 전달받은 값으로 수정
		String saveDir = "/resources/uploadFile/";
		
		// 수정할 첨부 파일이 있을경우
		if(!reupfile.getOriginalFilename().equals("")) {
			// 기존 첨부 파일이 있다 -> 기존 파일을 삭제
			if(b.getOriginName() != null) {
				new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
			}
			
			// 새로운 첨부파일을 서버에 업로드하기
			String changeName = Template.saveFile(reupfile, session, saveDir);
			
			b.setOriginName(reupfile.getOriginalFilename());
			b.setChangeName(saveDir + changeName);
		}
		
		// b정보로 업데이트
		int result = boardService.updateBoard(b);
		
		if(result > 0) { // 성공 > list페이지로 이동
			session.setAttribute("alertMsg", "게시글 수정 성공");
			return "redirect:detail.bo?bno=" + b.getBoardNo();
		} else { // 실패  > 에러페이지
			m.addAttribute("errorMsg","게시글 수정 실패");
			return "common/errorPage";
		}
	}
	
	@ResponseBody // value="주소명", produces="반환값 타입"
	@RequestMapping(value="rlist.bo", produces="application/json; charset=UTF-8")
	public String ajaxSelectReplyList(int bno) {
		ArrayList<Reply> list = boardService.selectReply(bno);
		
		return new Gson().toJson(list);
	}
	
	@ResponseBody
	@RequestMapping("rinsert.bo")
	public String ajaxInsertReply(Reply r) { // 프론트에서 vo와 이름을 맞췄으므로 잘 받아짐
		// 성공했을 때 success, 실패했을 때 fail return
		return boardService.insertReply(r) > 0 ? "success" : "fail";
		
	}
	
	@ResponseBody
	@RequestMapping(value="topList.bo", produces="application/json; charset=UTF-8")
	public String ajaxTopBoardList() {
		return new Gson().toJson(boardService.selectTopBoardList());
	}
}
