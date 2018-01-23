package com.ocj.basic;

import java.sql.Connection;
import java.sql.SQLException;

import com.ocj.db.ConnectionPool;

public class DbcpMain {
	public static void main(String[] args) throws SQLException {
		// DBCP 클래스는 <<ConnectionPool은>> singleton 형식으로 만들어졌다.
		// = > 생성자로 인스턴스를 생성할 수 없다.
		
		// DBCP 인스턴스를 반환받아 저장
		ConnectionPool cp = ConnectionPool.getInstance();
		// properties에서 initialcons가 2로 설정되어 있어서 2개가 만들어져있다.
		// maxcons는 최대로 쓸 수 있는거 설정하는거
		// 그 이후로 더 만들면 에러 발생...
		// DBCP 인스턴스에 미리 생성된 Connection
		Connection con1 = cp.getConnection();
		System.out.println("con1 = "+ con1);
		cp.releaseConnection(con1);
		
		Connection con2 = cp.getConnection();
		System.out.println("con2 = "+ con2);
		cp.releaseConnection(con2);
	}
}
