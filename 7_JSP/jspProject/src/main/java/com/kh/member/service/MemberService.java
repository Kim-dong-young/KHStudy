package com.kh.member.service;

// static 메소드만 가져오기
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member member = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		return member;
	}

}
