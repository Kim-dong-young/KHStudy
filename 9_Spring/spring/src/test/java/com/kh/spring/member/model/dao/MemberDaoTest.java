package com.kh.spring.member.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit을 사용하여 스프링 컨텍스트 로드
@ContextConfiguration(locations = {
		"file:src/test/resources/root-context.xml",
		"file:src/test/resources/servlet-context.xml",
		"file:src/test/resources/spring-security.xml",
})
public class MemberDaoTest {
	
	// @ContextConfiguration을 통해 등록한 스프링 컨텍스트의 빈 목록 중
	// MemberDao를 구현하는 객체를 찾아서 주입해준다.
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Test // junit테스트 메서드를 지정함. Main처럼 단독으로 실행됨
	public void testLoginMember() {
		Member m = new Member(); // Test할 Member객체 생성
		m.setUserId("user01");
		
		// 아이디로 member 찾아오는 것을 예상
		m = memberDao.loginMember(sqlSession, m);
		if(m != null) { // 찾아왔다면
			// useNameEquals : m.getUserName() 값이 관리자와 같은지 확인
			assertEquals("userNameEquals", "관리자", m.getUserName());
		} else {
			fail("test LoginMember fail");
		}
	}

}
