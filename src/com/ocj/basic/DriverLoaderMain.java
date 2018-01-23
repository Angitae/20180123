package com.ocj.basic;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

//jdbc 프로그램을 작성하기 위해서는 JDBC Driver 클래스를
//인스턴스로 생성 후  DriverManager 인스턴스에 등록
// => DriverManager 인스턴스에 등록된 JDBC Driver 인스턴스로
// DBMS 접속
public class DriverLoaderMain {
	public static void main(String[] args) {
		//forName(클래스) : 클래스를 메모리에 로드하여 저장하는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 인스턴스 생성 후 DriverManager 등록");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 클래스 찾을 수 없음");
			System.exit(0);
		}
		System.out.println("============================");
		//getDrivers() : DriverManager 인스턴스에 등록된 JDBC Driver
		//인스턴스의 목록을 반환하는 메소드
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driver = driverList.nextElement();
			System.out.println(driver);
		}
	}
}
