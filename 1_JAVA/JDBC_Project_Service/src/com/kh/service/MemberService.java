package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

// 실제 비지니스 로직이 구현되는곳
public class MemberService {
	// 1) JDBC Driver 등록
	// 2) Connection 객체 생성
	// 3) Connection 객체 처리
	
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public List<Member> selectMemberList() {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> list = new MemberDao().selectMemberList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public Member searchMemberById(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().searchMemberById(conn, userId);
		
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Member> searchMemberByName(String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list  =new MemberDao().searchMemberByName(conn, keyword);
		
		JDBCTemplate.close(conn);
		return list;
	}
}
