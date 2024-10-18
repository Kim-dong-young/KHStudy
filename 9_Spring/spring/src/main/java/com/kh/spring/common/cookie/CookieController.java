package com.kh.spring.common.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	/*
	 * 브라우저(클라이언트)의 저장공간 2개 => LocalStorage(큰 용량 100MB~ , Cookie 작은 용량 ~5MB)
	 * 
	 * cookie
	 * 브라우저에 저장되는 데이터 조각, 주로 사용자를 식별하고 상태정보를 기록하는데 사용된다.( 키-값 형태 )
	 * 쿠키는 클라이언트(브라우저)의 로컬 저장소에 저장된다.
	 * 저장된 쿠키정보는 서버에 http요청시 헤더에 담겨 함께 전송된다.
	 * 
	 * 쿠키는 보안성이 낮고 개인정보 유출에 취약할 수 있다. 
	 * 따라서 중요정보를 저장하는데 사용하려면 보안적인 조취가 필요하다.
	 * => 로그인 정보 그런거 담지마라
	 */
	
	@RequestMapping("create")
	public String create(HttpServletResponse response) {
		// 쿠키는 객체를 생성한 다음 응답정보에 첨부할 수 있다.
		// name, value 속성을 필수로 작성해야한다.
		
		Cookie ck = new Cookie("test","choijiwon");
		response.addCookie(ck);
		
		return "cookie/create";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletResponse response) {
		// 쿠키는 삭제 명령어가 따로 없음
		Cookie ck = new Cookie("test","choijiwon");
		ck.setMaxAge(0);
		response.addCookie(ck);
		
		return "cookie/delete";
	}
}
