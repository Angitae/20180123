package com.ocj.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

Scanner scanner = new Scanner(System.in);
		
		System.out.println("학생정보 입력");
		System.out.print("학번 >> ");
		int num = scanner.nextInt();
		System.out.print("이름 >>");
		String name = scanner.next();
		System.out.print("생년월일 >>");
		String birthday = scanner.next();
		scanner.close();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, user, password);
		
		//PreparedStatement 인스턴스는 SQL 명령을 미리 저장하여 생성
		// => ?(InParameter)를 이용하여 Java 변수값을 대신 하여 사용
		String sql = "insert into student valuse(?,?,?)";
		PreparedStatement  pstmt = con.prepareStatement(sql);
		//SQL 명령에 ?가 있는 경우 setXXX(index,변수값)
		//InParameter에 Java 변수값을 전달하여 SQL 명령 완성
		pstmt.setInt(1, num);
		pstmt.setString(2, name);
		pstmt.setString(3, birthday);
		
		int rows = pstmt.executeUpdate();
		System.out.println(rows+"명의 학생정보를 저장하였습니다.");
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
		
	}
}
