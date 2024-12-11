package com.kh.spring.member.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit을 사용하여 스프링 컨텍스트 로드
@WebAppConfiguration // Controller는 외부 요청이 없기 떄문에 Http 요청가능한  MockMVC가 필요
@ContextConfiguration(locations = {
		"file:src/test/resources/root-context.xml",
		"file:src/test/resources/servlet-context.xml",
		"file:src/test/resources/spring-security.xml",
})
public class MemberControllerTest {
	
	@Autowired
	private WebApplicationContext wac; // 웹 애플리케이션 컨텍스트
	
	private MockMvc mockMvc;
	
	@Before // Test 메서드가 실행되기 전에 실행하는 메서드
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("=============== MockMvc 준비 완료 ================");
	}
	
	@Test
	public void testLoginMember() {
		try {
			mockMvc.perform(
					post("/login.me") // POST 메서드로 login.me에 요청
					.param("userId","admin") // 요청에 파라미터 설정
					.param("userPwd","1234")
			).andDo(print()) // 요청한 정보에 대한 응답코드를 출력 ( 성공 : 200 )
			.andExpect(status().isFound()) // 상태코드 302(리다이렉트 받으면 302)인지
			.andExpect(redirectedUrl("/")); // 리다이렉트 받았을때, 경로가 root인지
		} catch (Exception e) {
			e.printStackTrace();
		}
		//	.andExpect(status().isOk()) 포워딩 API 테스트
	}
	
	@Test
	public void testIdCheck() {
		MvcResult result; // 요쳥 결과를 받아줄 result객체
		
		try {
			result = mockMvc.perform(
						get("/idCheck.me")
						.param("checkId", "jiwon0000")
					).andExpect(status().isOk())
					.andReturn();
			
			String content = result.getResponse().getContentAsString();
			assertEquals("NNNNY", content); // 아이디 사용가능을 예상함
		} catch (Exception e) {
			e.printStackTrace();
		} // 요쳥 결과를 반환
	}

}
