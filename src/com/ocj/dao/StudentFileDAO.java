package com.ocj.dao;

import java.util.List;

public class StudentFileDAO implements StudentDAO{

	@Override
	public int addStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		System.out.println("���Ͽ� �л������� �����Ͽ����ϴ�.");
		return 0;
	}

	@Override
	public int modifyStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		System.out.println("���Ͽ� ����� �л������� �����Ͽ����ϴ�.");
		return 0;
	}

	@Override
	public int removeStudent(int num) {
		// TODO Auto-generated method stub
		System.out.println("���Ͽ� ����� �л������� �����Ͽ����ϴ�.");
		return 0;
	}

	@Override
	public StudentDTO getStudent(int num) {
		// TODO Auto-generated method stub
		System.out.println("���Ͽ� ����� �ش� �л������� �˻��Ͽ����ϴ�.");
		return null;
	}

	@Override
	public List<StudentDTO> getStudentList() {
		// TODO Auto-generated method stub
		System.out.println("���Ͽ� ����� ��� �л������� �˻��Ͽ����ϴ�.");
		return null;
	}

}
