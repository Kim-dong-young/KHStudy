package com.kh.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청시 전달된 값들은 request의 Parameter 영역에 있음
		String name = request.getParameter("name"); // "최지원" | ""
		String gender = request.getParameter("gender"); // "M" | "F" | null(입력 안하면 아예 안옴)
		int age = Integer.parseInt(request.getParameter("age")); // "23" => 23
		
		// selectbox는 null이 올 수가 없다
		String city = request.getParameter("city"); // "경기" | "서울" | ... 등등
		
		double height = Double.parseDouble(request.getParameter("height")); // "179" => "179.000.."
		
		// checkbox 같이, 값이 여러개 올 수 있는 경우
		String[] food = request.getParameterValues("food"); // ["한식 , "중식"] | null
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		
		if(food == null) {
			System.out.println("food : 없음");
		} else {
			System.out.println("food : " + String.join(" ", food));
		}
		
		// > Service > DAO > DB
		/*
		 * int result = new MemberService().insertMember(name, gender...);
		 * if( result > 0 ) }
		 *  	// 성공
		 * } else {
		 *   	// 실패
		 * }
		 */
		
		// 순수 servlet방식 : java코드 내에 html을 기술
		// JSP(Jakarta Server Page)방식 : html 내에 java코드를 쓸 수 있음
		
		// 웅덥페이지를 만드는 과정을 jsp에게 위임
		// 단, 응답화면에서 필요로하는 데이터들을 차곡차곡 담아서 전달해줘야한다.
		// 데이터들을 담기위한 공간 == request의 attribute영역
		// request.setAttribute("키",값)
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("gender", gender);
		request.setAttribute("food", food);
		
		// 응답하고자 하는 뷰(jsp) 선택해서 넘겨줌 -> RequestDispatcher 객체 생성
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
