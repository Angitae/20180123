package com.ocj.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Ű����� �л� ������ �Է¹޾� Student ���̺� �����ϴ� ���α׷�
public class StatementMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�л����� �Է�");
		System.out.print("�й� >> ");
		int num = scanner.nextInt();
		System.out.print("�̸� >>");
		String name = scanner.next();
		System.out.print("������� >>");
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
		System.out.println(rows + "���� �л� ������ ���� �Ͽ����ϴ�.");
		if(stmt!=null) stmt.close();
		if(con != null) con.close();
	}
}
