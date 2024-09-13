package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//공통 탬플릿(매번 반복적으로 작성될 코드를 메소드로 정리)
public class JDBCTemplate {
	// 모두 static 메소드
	// 싱글톤 패턴 : 메모리 영역에 단 한번만 올려두고 매번 재사용하는 개념
	
	// 1. Connection 객채 생성(DB 접속) 후 해당 Connection 객체 반환
	public static Connection getConnection() {
		Connection conn = null;
		/*
		 *	서버는 중간에 멈추면 안된다
		 *  일단 배포되면, 이미 컴파일된 class 파일을 다시 바꾸긴 쉽지 않다
		 *  그래서, 경로 지정을 그냥 문자열이 아닌 외부 파일을 참조하도록 해두면
		 *  서버를 재시작 시키지 않고도 변경사항을 반영시킬 수 있다. 
		 */
		Properties prop = new Properties();
		
		// 읽어들이고자하는 classes폴더내의 driver.properties파일의 물리적인 경로 가져오기
		String filePath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getPath();
		// System.out.println(filePath);
		
		try {
			prop.load(new FileInputStream(filePath));
			// 1) JDBC 드라이버 등록
			Class.forName(prop.getProperty("driver"));
			
			// 2) Connection객체 생성
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			conn.setAutoCommit(false); // 수동 커밋 설정
			//System.out.println("db연결 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 2. commit 처리해주는 메소드(Connection 객체를 전달 받아서)
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. rollback 처리해주는 메소드(Connection 객체를 전달 받아서)
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// JDBC용 객체들을 전달받아서 반납처리해주는 메소드
	// 4. Statement 관련 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. Connection 관련 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 6. ResultSet 관련 객체를 전달받아서 반납시켜주는 메소드
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
