package com.ocj.basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudentMain {
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver를 찾을 수 없습니다.");
			System.exit(0);
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);

			stmt = con.createStatement();
			
			String sql = "select * from student order by num";
			rs = stmt.executeQuery(sql);
			
			//rs.next() : ResultSet 커서를 아래로 이동하는 메소드
			// => ResultSet 커서 위치에 행이 존재할 경우 true 반환
//			if(rs.next()) {
//				System.out.println("검색된 학생정보가 있습니다.");
//			}
//			else {
//				System.out.println("검색된학생정보가 없습니다.");
//			}
			
			// => ResultSet 커서 위치에 행이 존재할 경우 반복
			while(rs.next()) {
				//ResultSet 커서 위치에 행의 컬럼값을 반환받아 저장
				// => getXXX(index 또는 컬럼명) 메소드 호출
				// => xxx는 컬럼값에 대한 자료형
				// int num = rs.getInt(1); // index 이용 : 1부터 1씩 증가되는 정수
				int num = rs.getInt("num"); //컬럼명 이용(권장)
				String name = rs.getString("name");
//				Date birthday = rs.getDate("birthday");
				String birthday = rs.getString("birthday").substring(0, 10);
				//getString("컬럼명") : 모든 컬럼값을 문자열로 반환 가능

				//반환받은 컬럼값 출력
				System.out.println("학번 : " + num + " 이름 : " + name + " 생년월일 : " + birthday);
			}
			
		} catch (Exception e) {
			System.out.println("sql 오류" + e.getMessage());// TODO: handle exception
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
