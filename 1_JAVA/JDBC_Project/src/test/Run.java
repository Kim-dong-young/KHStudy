package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Run {
	/*
	 * JDBC를 사용하기 위해서는 자바 프로젝트에 JDBC드라이버를 추가해줘야 한다.
	 * JDBC 드라이버 다운로드 받을 때, 지원하는 자바버전을 확인하고 받자.
	 * 
	 * *JDBC용 객체
	 * 	- Connection : DB의 연결정보를 담고있는 객체
	 *  - [Prepared]Statement : 연결된 DB에 SQL문을 전달해서 실행하고, 결과를 받아내는 객체
	 *  - ResultSet : SELECT문 실행 후 조회된 결과물을 담는 객체
	 *  ## 나머지 UPDATE, DELETE, INSERT 등등은 영향을 받은 행의 개수를 RETURN한다.
	 *     Ex) update 3개 => return 3, insert 10 => return 1, delete xxx => return 0 (안지워짐)
	 *  
	 *  * JDBC 과정
	 *  1) JDBC Driver 등록 : 해당 DBMS(오라클)가 제공하는 클래스 등록
	 *  2) Connection 생성 : 연결하고자하는 db 정보를 입력해서 해당 db와 연결할 수 있는 객체
	 *  3) Statement생성 : Connection 객체를 이용해서 생성
	 *  4) SQL문 전달하면서 실행 : Statement객체를 이용해서 SQL문 실행
	 *  5) 결과 받기 > SELECT문 실행(6_1) -> ResultSet 객체 / DML문 실행(6_2) -> int
	 *  
	 *  6_1 ) SELECT문 실행 후
	 *  	- ResultSet 객체에 담겨있는 데이터들을 하나하나 추출해서 옮겨담기[ArrayList에 담기]
	 *  6_2 ) DML문 실행 후
	 *  	- 트랜잭션 처리 ( 성공하면 COMMIT / 실패했다면 ROLLBACK 실행 )
	 *  
	 *  7) 다 사용한 JDBC용 객체를 반드시 자원 반납(close) -> 생성된 역순으로
	 *  
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("번호 ㅣ ");
		int num = s.nextInt();
		s.nextLine();
		
		System.out.print("이름 ㅣ ");
		String name = s.nextLine();
		
		Connection conn = null;
		Statement stmt =null;

		// 실행할 sql문 -- 세미콜론 자동처리 됨, !!! 세미콜론 안붙여야 함!!! 붙이면 에러
		String sql = "INSERT INTO TEST VALUES(" + num + ", '" + name + "'," + "SYSDATE)";
		// "INSERT INTO TEST VALUES( 10 , '최지원' , SYSDATE)"
		
		try {
			// 1) JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ojdbc11.jar파일을 추가하지 않거나 오타가 있으면 -> 에러
			System.out.println("OracleDriver 등록 성공");
			
			// 2) Connection 생성 (url, 계정명, 비밀번호)
			// 								   (jdbc:oracle:thin:내가 연결할 IP주소)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			conn.setAutoCommit(false); // => commit 수동으로 하기위해 false로 설정한다.
			
			// 3) Statement 생성
			stmt = conn.createStatement();
			
			// 4 & 5 ) SQL문 전달하면서 실행 후 결과 받기
			int result = stmt.executeUpdate(sql);
			// 내가 실행할 sql문이 DML( INSERT, UPDATE, DELETE ) -> stmt.executeUpdata(sql문) : int
			// 내가 실행할 sql문이 DQL( SELECT ) -> stmt.executeQuery(select문) : ResultSet
			
			// 6) 트랜잭션 처리
			// 요청 성공 - 최소 1개 삽입하니, 최소 기댓값 = 1
			if ( result > 0 ) {
				// java.sql.SQLException: ORA-17273: 자동 커밋이 사용으로 설정된 채 커밋할 수 없습니다.
				// => conn.setAutoCommit(false); 하거나
				// => DB에서 SET AUTOCOMMIT OFF; 실행할 것
				conn.commit();
			}
			// 요청 실패
			else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 7) 다 쓴 JDBC 객체를 반납한다. ( 생성의 역순으로 )
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
