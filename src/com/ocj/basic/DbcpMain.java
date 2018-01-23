package com.ocj.basic;

import java.sql.Connection;
import java.sql.SQLException;

import com.ocj.db.ConnectionPool;

public class DbcpMain {
	public static void main(String[] args) throws SQLException {
		// DBCP Ŭ������ <<ConnectionPool��>> singleton �������� ���������.
		// = > �����ڷ� �ν��Ͻ��� ������ �� ����.
		
		// DBCP �ν��Ͻ��� ��ȯ�޾� ����
		ConnectionPool cp = ConnectionPool.getInstance();
		// properties���� initialcons�� 2�� �����Ǿ� �־ 2���� ��������ִ�.
		// maxcons�� �ִ�� �� �� �ִ°� �����ϴ°�
		// �� ���ķ� �� ����� ���� �߻�...
		// DBCP �ν��Ͻ��� �̸� ������ Connection
		Connection con1 = cp.getConnection();
		System.out.println("con1 = "+ con1);
		cp.releaseConnection(con1);
		
		Connection con2 = cp.getConnection();
		System.out.println("con2 = "+ con2);
		cp.releaseConnection(con2);
	}
}
