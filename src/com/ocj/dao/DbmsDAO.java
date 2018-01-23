package com.ocj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ocj.db.ConnectionPool;

// JDBC ����� �����ϴ� Ŭ������ �ݵ�� ��� �޾� ����ϴ� Ŭ����
// = > DBCP�κ��� connection �ν��Ͻ��� ��ȯ�޾� ����ϴ� �޼ҵ�
// = > connection �ν��Ͻ��� DBCP �ν��Ͻ��� �ݳ��ϴ� �޼ҵ�

public class DbmsDAO {
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close(Connection con) {
		try {
			if(con != null)
				ConnectionPool.getInstance().releaseConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null){
				pstmt.close();
			close(con);
			}
//			if(con != null)
//				ConnectionPool.getInstance().releaseConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null){
				rs.close();
			close(con, pstmt);}
//			if(pstmt != null)
//				pstmt.close();
//			if(con != null)
//				ConnectionPool.getInstance().releaseConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
