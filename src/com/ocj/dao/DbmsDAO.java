package com.ocj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ocj.db.ConnectionPool;

// JDBC 기능을 구현하는 클래스가 반드시 상속 받아 사용하는 클래스
// = > DBCP로부터 connection 인스턴스를 반환받아 사용하는 메소드
// = > connection 인스턴스를 DBCP 인스턴스로 반납하는 메소드

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
