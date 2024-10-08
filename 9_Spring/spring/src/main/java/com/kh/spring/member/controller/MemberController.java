package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

// Bean에 Class를 등록하는 방법으로 @Component를 클래스에 부여해주면 된다.
// @Component	   // Bean에 등록됨
// @Controller ->  @Component처럼 Bean에 등록 + Controller에 필요한 예외처리 추가
/*
  @CrossOrigin
    클라이언트의 IP+포트와 서버의 IP+포트는 다르다. 이 때, CrossOrigin 보안정책에 의해 접속이 막힌다.
    다른 IP를 가진 웹 브라우저에서도 접속할 수 있도록 해줌, 나중엔 crossorigin 필터로 한다

 */
// @RestController : AJAX용 어노테이션, 모든 서블릿(메소드)에 @ResponseBody가 적용됨.
// @ResponseBody // 데이터만 주고받는 RestAPI ajax 처리용, 기본 반환값 String
@Controller
@CrossOrigin 
public class MemberController {
	
	/*
	 * @Autowired
	 * 의존성 주입을 사용할 때 사용하는 어노테이션
	 * 클래스 내에서 필요한 객체를 직접 생성하지 않고 spring 컨테이너가 관리하는 객체(Bean)를 주입받아 사용할 수 있게 해준다.
	 * + 필드 주입 방식(지금 쓰고있는 방식) / 생성자 주입 방식 이 있다.
	 */
//	@Autowired
//	private MemberService memberService; // 보통은 이것보단 생성자 주입방식을 현업에서 더 많이 쓴다. 나중에 직접 하면 이해될 것

	/*
	 * 기존 객체 생성 방식
	 * private MemberService memberService = new MemberServiceImpl();
	 * => 객체간의 결합도가 높아짐 ( 수정해야되면 내가 일일이 바꿔줘야 함 )
	 * 서비스가 동시에 매우 많은 회수요청이 될 경우, 그만큼 객체가 생성된다.
	 * 
	 * DI(Dependency Injection) - 의존성 주입
	 * 코드 결합도가 낮아지고 코드를 분리할 수 있음
	 * 
	 * 필드 주입 방식
	 * 스프링 컨테이너가 객체를 " 생성한 후 ", @Autowired 어노테이션이 붙은 필드에 Setter을 이용해 의존성을 주입한다.
	 * 
	 * 생성자 주입 방식
	 * 스프링 컨테이너가 객체를 " 생성할 때 ", 생성자를 통해서 필요한 의존성을 주입한다.
	 * 
	 * 필드 주입 방식보단 생성자 주입 방식이 낫다.
	 * 주입 시점의 차이로 인해 객체가 완전히 초기화된 상태로 사용할 수 있음을 보장하고
	 * 테스트 기능성과 유지보수성이 좋아진다.
	 * 
     * 필드 의존성 주입 방식은 멀티 쓰레드 환경에서 문맥교환 발생시 잠깐이지만 memberService변수가 비어있는 순간이 생긴다.
	 * ex) 스프링의 Controller 생성과정
	 * 스프링 어디선가
	 * MemberController mc = new MemberController();
	 * ==== 이떄 다른 쓰레드로 넘어가면 memberService가 비어있는 상태, 안정성 떨어짐 ====
	 * mc.setMemberService( new MemberService() );
	 * 
	 * 생성자 주입 방식은 애초에 객체를 생성할 때, memberService객체를 생성하고 주입해준다.
	 * MemberController mc = new MemberController( new MemberService() );
	 */
	
	// 생성자 주입 방식
	private final MemberService memberService;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.memberService = memberService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}
	
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
	/* 1. 스프링에서 제공하는 Model객체를 이용하는 방법
	   	포워딩할 응답뷰로 전달하고자 하는 데이터를 맵 형식(key-value)으로 담을 수 있는 영역
	   	Model객체는 requestScope
	   	request.setAttribute(); -> model.addAttribute();
	*/
//	@RequestMapping("login.me")
//	public String loginMember(Member m, HttpSession session, Model model) {
//	
//		Member loginMember = memberService.loginMember(m);
//	
//		if(loginMember == null) {
//			System.out.println("로그인 실패");
//			model.addAttribute("errorMsg", "로그인 실패"); // requestScope에 에러문구를 담는다.
//			//  /WEB-INF/views/common/errorPage.jsp
//			return "common/errorPage";
//		} else {
//			session.setAttribute("loginUser", loginMember);
//			System.out.println("로그인 성공");
//			
//			return "redirect:/"; // contextPath로 이동
//		}
//
//	}
	
	// 2. 스프링에서 제공하는 ModelAndView 객체를 이용하면 데이터를 담고 리턴 형식까지 지정할 수 있음
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, HttpSession session, ModelAndView mv) {
	
//		Member loginMember = memberService.loginMember(m);
//	
//		if(loginMember == null) {
//			System.out.println("로그인 실패");
//			mv.addObject("errorMsg", "로그인 실패");
//			
//			mv.setViewName("common/errorPage");
//			
//		} else {
//			session.setAttribute("loginUser", loginMember);
//			System.out.println("로그인 성공");
//			
//			mv.setViewName("redirect:/");
//		}
		
		// 암호화 후
		// Member m의 id -> 사용자가 입력한 아이디
		// Member m의 pwd -> 사용자가 입력한 pwd(평문)
		
		// 우선 ID로만 member 정보를 가져온다
		Member loginMember = memberService.loginMember(m);
		
		// loginMember pwd -> 암호화된 비밀번호
		// bcryptPasswordEncoder -> matches(평문, 암호문) 메소드를 이용하여 내부적으로 복호화 작업 후에 비교가 이루어짐
		// 두 구문이 일치하면 true를 반환, 일치하지 않으면 false 반환
		
		if(loginMember == null) {
		System.out.println("로그인 실패");
		mv.addObject("errorMsg", "일치하는 아이디를 찾을 수 없습니다.");
		
		mv.setViewName("common/errorPage");
			
		} else if(!bcryptPasswordEncoder.matches(m.getUserPwd(), loginMember.getUserPwd())) {
			
			mv.addObject("errorMsg", "비밀번호가 일치하지 않습니다.");
			
			mv.setViewName("common/errorPage");
		} else {
			session.setAttribute("loginUser", loginMember);
			System.out.println("로그인 성공");
			
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@GetMapping("logout.me")
	public String logoutMember(HttpSession session) {
		// session.invalidate();
		// session.setAttribute("loginUser", null); 이것도 되던데
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
	
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	/*
	 * ajax요청에 대한 응답을 위한 controller에는 @ResponseBody 어노테이션을 작성해줘야한다.
	 * 기본적인 세팅이 jsp 응답으로 되어있기 때문에, jsp페이지 응답이 아닌 
	 * 반환값을 Http 응답객체에 직접 작성하겠다는 의미.
	 */
	@ResponseBody // 데이터만 주고받는 RestAPI ajax 처리용, 기본 반환값 String
	@RequestMapping("idCheck.me")
	public String idCheck(String checkId) {
		int result = memberService.idCheck(checkId);
		
		if(result > 0) {
			return "NNNNN";
		} else {
			return "NNNNY";
		}
	}
	
	@PostMapping("insert.me")
	public String insertMember(Member m, HttpSession session, Model model) {
		// 한글이 안깨지는 이유 : web.xml에 filter로 encodingFilter 설정해놨기 때문
		System.out.println(m);
		
		/*
		 * age 같은 경우, int로 필드를 구성할 경우 빈 문자열이 전달되면 형변환 과정에서 400 에러가 발생
		 * 400 에러는 보통 요청하는 데이터와 이를 받아주는 데이터가 일치하지 않아서 많이 발생된다.
		 * 스프링이 데이터 넣다가 문제가 생기면 알아서 400 에러를 반환해준다. 그래서 서버 콘솔에는 안찍힌다.
		 * 
		 * 비밀번호가 사용자의 입력 그대로 전달된다.(평문)
		 * Bcrypt방식을 이용해서 암호화 작업 후 저장을 하겠다.
		 * => 스프링 시큐리티에서 제공하는 모듈 이용 ( pom.xml에 라이브러리 추가 후, 빈에 객체 등록 )
		 */
		
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd);
		
		int result = memberService.insertMember(m);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("myPage.me")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("update.me")
	public String updateMember(Member m, HttpSession session, Model model) {
		int result = memberService.updateMember(m);
		
		if(result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			return "redirect:/myPage.me";
		} else {
			model.addAttribute("errorMsg", "회원정보 수정 실패"); // request 영역에 담기
			return "common/errorPage";
		}
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(Member m, HttpSession session, Model model) {
		// 비밀번호를 암호화된 비밀번호와 비교
		String encPwd = ((Member)session.getAttribute("loginUser")).getUserPwd();
		
		// 일치하면 탈퇴처리 -> session에서 로그인정보 제거 -> 메인페이지
		// 일치하지 않으면 -> alertMsg : 비밀번호를 다시 입력 -> 마이페이지
		int result = 0;
		if(bcryptPasswordEncoder.matches(m.getUserPwd(), encPwd)) {
			result = memberService.deleteMember(m);
		} else {
			session.setAttribute("alertMsg", "비밀번호를 다시 입력해주세요."); // request 영역에 담기
			return "redirect:/myPage.me";
		}
		
		if(result > 0) {
			session.removeAttribute("loginUser");
			session.setAttribute("alertMsg", "회원탈퇴 성공");
			return "redirect:/";
		} else {
			session.setAttribute("errorMsg", "회원탈퇴 실패"); // request 영역에 담기
			return "redirect:/myPage.me";
		}
	}
}
