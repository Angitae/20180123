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
		
		//PreparedStatement �ν��Ͻ��� SQL ����� �̸� �����Ͽ� ����
		// => ?(InParameter)�� �̿��Ͽ� Java �������� ��� �Ͽ� ���
		String sql = "insert into student valuse(?,?,?)";
		PreparedStatement  pstmt = con.prepareStatement(sql);
		//SQL ��ɿ� ?�� �ִ� ��� setXXX(index,������)
		//InParameter�� Java �������� �����Ͽ� SQL ��� �ϼ�
		pstmt.setInt(1, num);
		pstmt.setString(2, name);
		pstmt.setString(3, birthday);
		
		int rows = pstmt.executeUpdate();
		System.out.println(rows+"���� �л������� �����Ͽ����ϴ�.");
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
		
	}
}
