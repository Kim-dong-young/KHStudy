package com.kh.spring.member.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	
	// 로그인
	Member loginMember(Member m);
	
	// 아이디 중복체크
	int idCheck(String checkId);

	// 회원가입
	int insertMember(Member m);

	// 회원정보 수정
	int updateMember(Member m);

	// 회원탈퇴
	int deleteMember(Member m);
}
