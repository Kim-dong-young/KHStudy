package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

public class MemberDao {
	private static MemberDao md;
	
	private MemberDao() {
		super();
	}
	
	public static MemberDao getInstance() {
		if(md == null)
			md = new MemberDao();
		return md;
	}

	public int createMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TB_MEMBER VALUES(MEMBER_UID_SEQ.NEXTVAL, ?, ?, ?, DEFAULT ,DEFAULT, DEFAULT, DEFAULT, DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getMemberId());
			pstmt.setString(3, m.getMemberPwd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Member searchMember(Connection conn, Member m) {
		Member foundMember = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				foundMember = new Member();
				foundMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				foundMember.setMemberId(rset.getString("MEMBER_ID"));
				foundMember.setMemberName(rset.getString("MEMBER_NAME"));
				foundMember.setMemberPwd(rset.getString("MEMBER_PWD"));
				foundMember.setMemberRcode(rset.getString("MEMBER_RCODE"));
				foundMember.setMemberUid(rset.getInt("MEMBER_UID"));
				foundMember.setWithdraw(rset.getString("WITHDRAW_YN").equals("Y"));
				foundMember.setDay(rset.getInt("PLAY_DAY"));
				foundMember.setBalance(rset.getInt("BALANCE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return foundMember;
	}

	public Member loadMemberInfo(Connection conn, Member m) {
		Member memberInfo = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM TB_MEMBER WHERE MEMBER_UID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberUid());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberInfo = new Member();
			
				memberInfo.setEnrollDate(rset.getDate("ENROLL_DATE"));
				memberInfo.setMemberId(rset.getString("MEMBER_ID"));
				memberInfo.setMemberName(rset.getString("MEMBER_NAME"));
				memberInfo.setMemberPwd(rset.getString("MEMBER_PWD"));
				memberInfo.setMemberRcode(rset.getString("MEMBER_RCODE"));
				memberInfo.setMemberUid(rset.getInt("MEMBER_UID"));
				memberInfo.setWithdraw(rset.getString("WITHDRAW_YN").equals("Y"));
				memberInfo.setDay(rset.getInt("PLAY_DAY"));
				memberInfo.setBalance(rset.getInt("BALANCE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return memberInfo;
	}
}
