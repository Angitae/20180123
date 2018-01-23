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
		// 1. JDBC ����̹��� �޸� �ε��Ͽ� ����
		// => Driver �ν��Ͻ� ���� �� DriverManager ���

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver �ν��Ͻ� ���� �� DriverManager ���");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver Ŭ���� ã�� �� ����");
			System.exit(0);
		}

		Connection con = null;
		Statement stmt = null;
		// 2. DriverManager�� ��ϵ� Driver �ν��Ͻ��� DBMS ����
		// => getConnection() �޼ҵ带 ȣ���Ͽ� s
		// DBMS ������ URL �ּ�, ����ڸ�, ��й�ȣ�� �����Ͽ� ����
		// => URL �ּ� - jdbc:oracle:thin:@������(ip�ּ�):1521:SID
		// => ���� ���� ���� �� Connection �ν��Ͻ��� �����Ͽ� ��ȯ
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);

			// 3. SQL ����� �����Ͽ� DBMS���� �����ϴ� �ν��Ͻ���
			// Connection �ν��Ͻ��κ��� ��ȯ�޾� ����
			stmt = con.createStatement();

			// 4. SQL ����� �����Ͽ� DBMS���� �����Ͽ� ����� ��ȯ�޾� ����
			// stmt.executeUpdate(sql) : DML ����� ���޹޾� �����ϴ� �޼ҵ� (insert, update,delete)
			// => int ��� ��ȯ
			// stmt.executeQuery(sql) : DQL ����� ���޹޾� �����ϴ� �޼ҵ� (select)
			// => Resultset �ν��Ͻ� ��ȯ
			//String sql = "insert into student values(1000,'ȫ�浿', '2000-01-01')";
			String sql = "insert into student values(3000,'����ġ', '2001-01-01')";
			
			int rows = stmt.executeUpdate(sql);

			// 5. SQL ����� ���� �� ��ȯ���� ����� �̿��Ͽ� ó��
			System.out.println(rows + "���� �л������� �����Ͽ����ϴ�.");

		} catch (SQLException e) {
			System.out.println("SQL ���� : " + e.getMessage());
		} finally {
			// 6. SQL �ڿ� �ݳ� : Connection �ν��Ͻ��� ������ �ݳ�
			// =>  ������ �������� �ݳ�
				try {
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
