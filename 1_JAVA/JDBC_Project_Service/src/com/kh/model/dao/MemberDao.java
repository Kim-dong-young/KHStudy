package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

// DAO(Data Access Object) : DB에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
/*
 * ojdbc 설정법
 * 1. 프로젝트에 우클릭 -> Properties 클릭
 * 2. Java Build Path 선택
 * 3. Add External Jar 선택 -> ojdbc jar 불러오기
 */
public class MemberDao {
	
	/* < 에러 해결 >
	 * ORA-12505: 데이터베이스에 접속할 수 없습니다. SID xe이(가) host localhost port 1521의 리스너에 등록되지 않았습니다.
	 * => cmd창에 lsnrctl services 입력해서 다시 리스너 잡아준다 
	 * 
	 * ORA-12541: 접속할 수 없습니다. host localhost port 1541에 리스너가 없습니다.
	 * => 아마 니가 포트번호 잘못 입력했을 확률 99.999%
	 * => 아니면 작업관리자/서비스 창에서 오라클 리스너 실행시켜
	 */

	/**
	 * @param Member m : 사용자가 입력한 값들이 담겨있는 member객체
	 * @return : insert문 실행 후 처리된 행 수
	 */
	public int insertMember(Connection conn, Member m) {
		// insert문 => 처리된 행 수(int) => 트랜잭션에 쌓임
		
		// 필요한 변수 먼저 세팅
		int result = 0; // 처리된 결과를 받아줄 변수
		PreparedStatement pstmt = null; // 미완성 sql문을 통해서 객체생성 후 객체의 메소드를 이용해 완성 가능

		// pstmt에서 사용할 미완성 sql문
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		System.out.println("sql : " + sql);
		
		try {
			// 3) Statement 객체 생성
			// stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			// 4~5) SQL로 DB에 전달하고 실행 후 값 받아오기
			// result = stmt.executeUpdate(sql);
			// pstmt.executeUpdate() 는 sql을 넣지 않는다. 넣으면 미완성이라 에러, 오버로딩된 다른 메소드 호출해주자
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<Member> selectMemberList(Connection conn) {
		// select문(여러행 조회) -> ResultsSet객체 -> ArrayList<Member>에 담기
		// 필요한 변수들 세팅
		List<Member> list = new ArrayList<Member>(); // 비어있는 상태

		Statement stmt = null;
		ResultSet rset = null; // select문 실행 시 조회된 결과값들이 최초로 담기는 공간
		
		// 실행할 sql
		String sql = "SELECT * FROM MEMBER";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				// 현재 참조하고있는 행 모든 컬럼 데이터들을 한 Member 객체에 담기
				
				list.add(m);
			}
			// 반복문이 끝난 시점
			// 조회된 데이터가 없다면 list -> 비어있을 것이다.
			// 조회된 데이터가 있다면 전부 list에 담겨있을 것이다.
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}

	public int updateMember(Connection conn, Member m) {
		// update문 -> 처리된 행 수(int)
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER "
				+"SET USER_PWD = ?,"
				+"EMAIL = ?,"
				+"PHONE = ?,"
				+"ADDRESS = ?"
				+" WHERE USER_ID = ?";
		
		try {
			// sql -> 미완성( ? 사용했음 )
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, Member m) {
		
		int result = 0;
		String sql = "DELETE FROM MEMBER "
					+"WHERE USER_ID = ?";
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql); ){
			
			pstmt.setString(1, m.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member searchMemberById(Connection conn, String userId) {
		// select문(한행) -> ResultSet -> Member 객체
		
		Member m = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}

	public ArrayList<Member> searchMemberByName(Connection conn, String keyword) {
		
		ArrayList<Member> list  = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE '%' || ? || '%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

}
