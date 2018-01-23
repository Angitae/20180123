package com.ocj.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * create table student (num number(4) primary key
, name varchar2(20), birthday date);
 * 
 * */
public class AddStudentMain {
	public static void main(String[] args) {
		// 1. JDBC 드라이버를 메모리 로드하여 저장
		// => Driver 인스턴스 생성 후 DriverManager 등록

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 인스턴스 생성 후 DriverManager 등록");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 클래스 찾을 수 없음");
			System.exit(0);
		}

		Connection con = null;
		Statement stmt = null;
		// 2. DriverManager에 등록된 Driver 인스턴스로 DBMS 접속
		// => getConnection() 메소드를 호출하여 s
		// DBMS 서버의 URL 주소, 사용자명, 비밀번호를 전달하여 접속
		// => URL 주소 - jdbc:oracle:thin:@서버명(ip주소):1521:SID
		// => 서버 접속 성공 후 Connection 인스턴스를 생성하여 반환
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);

			// 3. SQL 명령을 저장하여 DBMS에서 전달하는 인스턴스를
			// Connection 인스턴스로부터 반환받아 저장
			stmt = con.createStatement();

			// 4. SQL 명령을 저장하여 DBMS에서 전달하여 결과를 반환받아 저장
			// stmt.executeUpdate(sql) : DML 명령을 전달받아 실행하는 메소드 (insert, update,delete)
			// => int 결과 반환
			// stmt.executeQuery(sql) : DQL 명령을 전달받아 실행하는 메소드 (select)
			// => Resultset 인스턴스 반환
			//String sql = "insert into student values(1000,'홍길동', '2000-01-01')";
			String sql = "insert into student values(3000,'전우치', '2001-01-01')";
			
			int rows = stmt.executeUpdate(sql);

			// 5. SQL 명령을 실행 후 반환받은 결과를 이용하여 처리
			System.out.println(rows + "명의 학생정보를 저장하였습니다.");

		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			// 6. SQL 자원 반납 : Connection 인스턴스는 무조건 반납
			// =>  생성된 역순으로 반납
				try {
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
