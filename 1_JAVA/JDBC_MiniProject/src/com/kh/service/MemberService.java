package com.kh.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {
	private static MemberService ms;
	
	private MemberDao md;
	
	private MemberService() {
		super();
		md = MemberDao.getInstance();
	}
	
	public static MemberService getInstance() {
		if(ms == null)
			ms = new MemberService();
		return ms;
	}

	public int createMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = md.createMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} 
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public Member searchMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		Member foundMember = md.searchMember(conn, m);

		JDBCTemplate.close(conn);
		return foundMember;
	}

	public Member loadMemberInfo(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		Member memberInfo = md.loadMemberInfo(conn, m);
		
		JDBCTemplate.close(conn);
		return memberInfo;
	}
}
