package com.kh.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberInfoUpdateController
 */
public class MemberInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		String userId = request.getParameter("userId"); // "user04"
		String phone = request.getParameter("phone"); // "010-1111-2222" || ""
		String email = request.getParameter("email"); // "user04@gmail.com" || ""
		String address = request.getParameter("address"); // "경기도 하남시" || ""
		String[] interestArr = request.getParameterValues("interest"); // ["운동","게임","영화"] || null
		
		// String[] -> String
		// ["운동","게임","영화"] -> "운동,게임,영화"
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = new Member(userId, phone, email, address, interest);
		
		// sql요청 -> service -> dao -> sql 실행
		Member updateMember = new MemberService().updateMember(m);
		
		if(updateMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMember);
			session.setAttribute("alertMsg", "성공적으로 정보수정 되었습니다.");

			response.sendRedirect(request.getContextPath() + "/mypage.me");
		} else {
			request.setAttribute("errorMsg", "정보수정에 실패하였습니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
