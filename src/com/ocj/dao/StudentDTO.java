package com.ocj.dao;

// DTO(Data Transfer Object) Ŭ���� => VO(Value Object) Ŭ���� ����
// => Application(Business Object)�� DAO(Data Access Object)���� 
//       �����͸� ������ ������ Ŭ����
// = > Data Source(���� or DBMS��)�� ����� ������ �����Ͽ� �����ϱ� ���� Ŭ����
// STUDENT ���̺��� �л������� �����Ͽ� �����ϱ� ���� Ŭ����
// = > �˻��ϰ��� �ϴ� �� �����͸� �ʵ�� ���� �� setter �� getter �޼ҵ� ���� 
public class StudentDTO {
	private int num;
	private String name;
	private String birthday;
//	
//	public static void main(String[] args) {
//			
//	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String toString(){
		return "�й� : "+num + "�̸�: " + name ;
	}
}
