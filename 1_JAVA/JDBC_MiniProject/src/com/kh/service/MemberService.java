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

	public int createUser(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = md.createUser(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} 
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
}
