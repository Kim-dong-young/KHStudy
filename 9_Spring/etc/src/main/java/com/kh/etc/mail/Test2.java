package com.kh.etc.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class Test2 {
	
	private final JavaMailSender sender;
	
	@Autowired
	public Test2(JavaMailSender sender) {
		this.sender = sender;
	}
	
	@GetMapping("hypermail")
	public String hypermail() throws MessagingException {
		// 메시지 생성
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		String[] to = {"ehddud9502@gmail.com"};
		helper.setTo(to); // 메시지 보낼 대상, 여러명 가능
		
		String[] cc = {"ehddud9502@gmail.com"};
		helper.setCc(cc); // 참조 설정
		
		helper.setSubject("이메일 전송 테스트");
		
		
		// 이메일 찾기시에 이메일 정보를 입력받아
		// uuid, 이메일, 시간을 DB에 기록
		// EX ) qdiqjaiwejgre / ehddud9502@gmail.com / 2024/11/11 12:44
		
		String url = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.port(7777).path("/changePassword")
				.queryParam("user_id", "ehddud9502")
				.queryParam("uuid","qdiqjaiwejgre")
				.toUriString();
		
		// 두번쨰 인자를 true로 보내면 html을 사용하겠다는 의미
		helper.setText("이메일 변경 링크 <br> "
				+ "<a href="+url+">사이트로 이동</a>",true);
		
		sender.send(message);
		
		return "redirect:/";
	}
	
	@GetMapping("sendfile")
	public String send() throws MessagingException {
		// 메시지 생성
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		String[] to = {"ehddud9502@gmail.com"};
		helper.setTo(to); // 메시지 보낼 대상, 여러명 가능
		
		String[] cc = {"ehddud9502@gmail.com"};
		helper.setCc(cc); // 참조 설정
		
		helper.setSubject("파일 전송 테스트");
		helper.setText("파일 전송 테스트입니다.");
		
		DataSource source = new FileDataSource("C:\\Users\\user1\\Desktop\\butter.webp");
		helper.addAttachment(source.getName(), source);
		
		sender.send(message);
		
		return "redirect:/";
	}
}
