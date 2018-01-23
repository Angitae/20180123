package com.ocj.basic;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

//jdbc ���α׷��� �ۼ��ϱ� ���ؼ��� JDBC Driver Ŭ������
//�ν��Ͻ��� ���� ��  DriverManager �ν��Ͻ��� ���
// => DriverManager �ν��Ͻ��� ��ϵ� JDBC Driver �ν��Ͻ���
// DBMS ����
public class DriverLoaderMain {
	public static void main(String[] args) {
		//forName(Ŭ����) : Ŭ������ �޸𸮿� �ε��Ͽ� �����ϴ� �޼ҵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver �ν��Ͻ� ���� �� DriverManager ���");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver Ŭ���� ã�� �� ����");
			System.exit(0);
		}
		System.out.println("============================");
		//getDrivers() : DriverManager �ν��Ͻ��� ��ϵ� JDBC Driver
		//�ν��Ͻ��� ����� ��ȯ�ϴ� �޼ҵ�
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driver = driverList.nextElement();
			System.out.println(driver);
		}
	}
}
