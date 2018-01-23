package com.ocj.dao;

// DTO(Data Transfer Object) 클래스 => VO(Value Object) 클래스 유사
// => Application(Business Object)과 DAO(Data Access Object)에서 
//       데이터를 전달할 목적의 클래스
// = > Data Source(파일 or DBMS등)의 저장된 정보를 저장하여 전달하기 위한 클래스
// STUDENT 테이블의 학생정보를 저장하여 전달하기 위한 클래스
// = > 검색하고자 하는 열 데이터를 필드로 구현 후 setter 및 getter 메소드 생성 
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
		return "학번 : "+num + "이름: " + name ;
	}
}
