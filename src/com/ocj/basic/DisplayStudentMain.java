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
			System.out.println("OracleDriver�� ã�� �� �����ϴ�.");
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
			
			//rs.next() : ResultSet Ŀ���� �Ʒ��� �̵��ϴ� �޼ҵ�
			// => ResultSet Ŀ�� ��ġ�� ���� ������ ��� true ��ȯ
//			if(rs.next()) {
//				System.out.println("�˻��� �л������� �ֽ��ϴ�.");
//			}
//			else {
//				System.out.println("�˻����л������� �����ϴ�.");
//			}
			
			// => ResultSet Ŀ�� ��ġ�� ���� ������ ��� �ݺ�
			while(rs.next()) {
				//ResultSet Ŀ�� ��ġ�� ���� �÷����� ��ȯ�޾� ����
				// => getXXX(index �Ǵ� �÷���) �޼ҵ� ȣ��
				// => xxx�� �÷����� ���� �ڷ���
				// int num = rs.getInt(1); // index �̿� : 1���� 1�� �����Ǵ� ����
				int num = rs.getInt("num"); //�÷��� �̿�(����)
				String name = rs.getString("name");
//				Date birthday = rs.getDate("birthday");
				String birthday = rs.getString("birthday").substring(0, 10);
				//getString("�÷���") : ��� �÷����� ���ڿ��� ��ȯ ����

				//��ȯ���� �÷��� ���
				System.out.println("�й� : " + num + " �̸� : " + name + " ������� : " + birthday);
			}
			
		} catch (Exception e) {
			System.out.println("sql ����" + e.getMessage());// TODO: handle exception
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
