package com.ocj.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//키보드로 학생 정보를 입력받아 Student 테이블에 저장하는 프로그램
public class StatementMain {
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
		Statement stmt = con.createStatement();
		
		String sql = "insert into student values ("+num+",'"+name+"','"+birthday+"')";
		int rows = stmt.executeUpdate(sql);
		System.out.println(rows + "명의 학생 정보를 저장 하였습니다.");
		if(stmt!=null) stmt.close();
		if(con != null) con.close();
	}
}
