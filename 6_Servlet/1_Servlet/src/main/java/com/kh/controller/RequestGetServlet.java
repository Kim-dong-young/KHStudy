package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 * http:localhost:5000/st/test1.do
 */

public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get방식으로 요청시 해당 doGet메소드가 저절로 호출된다.
		//System.out.println("서버에 요청이 정상적으로 도착함");
		
		/*
		 * 첫번째 매개변수인 request에는 요청시 전달된 내용들이 담겨있음(사용자가 입력한 값, 요청방식, 요청자의 IP 등)
		 * 두번째 매개변수인 response는 요청 처리 후 응답에 사용되는 객체
		 * 
		 * 요청처리를 위해서 요청시 전달된 값을 추출
		 * request의 parameter 영역안에 존재
		 * request.getParameter("키")
		 */
		
		String name = request.getParameter("name"); // "최지원" | ""
		String gender = request.getParameter("gender"); // "M" | "F" | null(입력 안하면 아예 안옴)
		int age = Integer.parseInt(request.getParameter("age")); // "23" => 23
		
		// selectbox는 null이 올 수가 없다
		String city = request.getParameter("city"); // "경기" | "서울" | ... 등등
		
		double height = Double.parseDouble(request.getParameter("height")); // "179" => "179.000.."
		
		// checkbox 같이, 값이 여러개 올 수 있는 경우
		String[] food = request.getParameterValues("food"); // ["한식 , "중식"] | null
		
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
		
		// 위의 결과에따라 응답페이지(html) 만들어서 전송
		// 즉, 여기 java코드내에 사용자가 보게 될 응답 html 구문을 작성
		
		// response 객체를 통해 사용자에게 html(응답화면) 전달
		// 1) 이제부터 내가 출력할 내용은 문서형태의 html이고 문자셋은 utf-8이다 -> 선언
		response.setContentType("text/html; charset=utf-8"); // 브라우저에게 전달할 파일형식, 인코딩 방식 정보
		
		// 2) 응답받는 사용자(요청했던 사람)와의 스트림(클라이언트와의 통로)를 생성
		PrintWriter out = response.getWriter();
		
		// 3) 위에서 가져온 스트림을 통해 응답 html을 한줄씩 출력
		out.println("<html>");
		
		out.println("<head>");
		out.println("<style>");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h2>개인정보 응답화면</h2>");
		out.printf("<span>%s님은 </span>", name);
		out.printf("<span>%d살이며 </span>", age);
		out.printf("<span>%s에 삽니다. </span>", city);
		out.println("성별은 ");
		if(gender == null) {
			System.out.println("선택하지 않았습니다.");
		} else {
			if(gender.equals("M")) {
				out.println("<span>남자입니다.</span>");
			}
			else {
				out.println("<span>여자입니다.</span>");
			}
		}
		
		out.println("</body>");
		
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
