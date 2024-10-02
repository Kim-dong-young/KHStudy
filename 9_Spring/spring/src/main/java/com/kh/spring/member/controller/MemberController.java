package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

// Bean에 Class를 등록하는 방법으로 @Component를 클래스에 부여해주면 된다.
// @Component	   // Bean에 등록됨
// @Controller ->  @Component처럼 Bean에 등록 + Controller에 필요한 예외처리 추가
@Controller
public class MemberController {
	
	/*
	 * @Autowired
	 * 의존성 주입을 사용할 때 사용하는 어노테이션
	 * 클래스 내에서 필요한 객체를 직접 생성하지 않고 spring 컨테이너가 관리하는 객체(Bean)를 주입받아 사용할 수 있게 해준다.
	 * + 필드 주입 방식(지금 쓰고있는 방식) / 생성자 주입 방식 이 있다.
	 */
	@Autowired
	private MemberService memberService; // 보통은 이것보단 생성자 주입방식을 현업에서 더 많이 쓴다. 나중에 직접 하면 이해될 것
	
	/*
	 * Spring에서 클라이언트가 보낸 정보를 받는 방법
	 * 
	 * 1. HttpServletRequest를 활용해서 전달값을 가져옴
	 * 메소드에 매개변수로 HttpServletRequest를 작성해두면
	 * 스프링 컨테이너가 해당 메소드를 호출할 때 자동으로 객체생성해서 매개변수로 주입해준다
	 */
//	@RequestMapping("login.me")  // RequestMapping : 이 주소로 get이든 post든 요청이 오면 아래 함수 실행
//	public String loginMember(HttpServletRequest request) {
//		String id = request.getParameter("userId");
//		String pwd = request.getParameter("userPwd");
//		
//		System.out.println(id);
//		System.out.println(pwd);
//		return null;
//	}
	
	/*
	 * 2. @RequestParam 어노테이션을 이용하는 방법
	 * request.getParameter(키)로 밸류를 추룰하는 역할을 대신해주는 어노테이션
	 * value속성의 값을 jsp에서 작성했던 name 속성값을 담으면 알아서 해당 매개변수로 받아올 수 있다.
	 * 만약, 요청할 때의 값이 비어있는 경우 defaultValue 속성으로 기본값을 지정할 수 있다.
	 * 
	 * ex) 
	 * 1. @RequestParam(value="userId(사용자가 보낸 데이터의 키 이름)", defaultValue="test222") String id;
	 * 2. String userId(사용자가 보낸 데이터의 키 이름);
	 * 
	 * default와 같은 설정을 사용하지 않고, 요청받은 key값과 매개변수명을 동일하게 해준다면
	 * @RequestParam 생략할 수 있다.
	 */
	
	/*
	 * 3. 커맨드 객체 방식
	 * 해당 메소드의 매개변수로 요청시 전달값을 담고자하는 클래스 타입으로 만들어 준 뒤
	 * 전달되는 key값과 매개변수 클래스의 필드명을 동일하게 작성해주면
	 * 객체를 생성하여 값을 담아서 전달해준다.
	 */
//	@RequestMapping("login.me")  // RequestMapping : 이 주소로 get이든 post든 요청이 오면 아래 함수 실행
//	public String loginMember(Member m) {
//		
//		Member loginMember = memberService.loginMember(m);
//		
//		if(loginMember == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//		}
//		
//		return "main";
//		/*
//		 * servlet-context.xml에서
//		 * 		접두어 : <beans:property name="prefix" value="/WEB-INF/views/" />
//				접미어 : <beans:property name="suffix" value=".jsp" />
//				다음과 같이 설정했으므로
//				return "main";   과 같이 작성시
//				=> /WEB-INF/views/ + main + .jsp  로 완성해서
//				해당 주소로 보내줌 = 즉, 기본이 forward
//		 * 
//		 */
//	}
	
	// 요청처리 후에 응답데이터를 담고 응답페이지로 포워딩 또는 url재요청 처리하는 방법
	// 1. 스프링에서 제공하는 Model객체를 이용해서 return해주기
	public String loginMember(Member m, HttpSession session) {
	
	Member loginMember = memberService.loginMember(m);
	
	if(loginMember == null) {
		System.out.println("로그인 실패");
	} else {
		session.setAttribute("loginUser", loginMember);
		System.out.println("로그인 성공");
	}
	
	return "main";
	/*
	 * servlet-context.xml에서
	 * 		접두어 : <beans:property name="prefix" value="/WEB-INF/views/" />
			접미어 : <beans:property name="suffix" value=".jsp" />
			다음과 같이 설정했으므로
			return "main";   과 같이 작성시
			=> /WEB-INF/views/ + main + .jsp  로 완성해서
			해당 주소로 보내줌 = 즉, 기본이 forward
	 * 
	 */
}

}
