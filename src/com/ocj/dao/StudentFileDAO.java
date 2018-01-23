package com.ocj.dao;

import java.util.List;

public class StudentFileDAO implements StudentDAO{

	@Override
	public int addStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		System.out.println("파일에 학생정보를 저장하였습니다.");
		return 0;
	}

	@Override
	public int modifyStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		System.out.println("파일에 저장된 학생정보를 변경하였습니다.");
		return 0;
	}

	@Override
	public int removeStudent(int num) {
		// TODO Auto-generated method stub
		System.out.println("파일에 저장된 학생정보를 삭제하였습니다.");
		return 0;
	}

	@Override
	public StudentDTO getStudent(int num) {
		// TODO Auto-generated method stub
		System.out.println("파일에 저장된 해당 학생정보를 검색하였습니다.");
		return null;
	}

	@Override
	public List<StudentDTO> getStudentList() {
		// TODO Auto-generated method stub
		System.out.println("파일에 저장된 모든 학생정보를 검색하였습니다.");
		return null;
	}

}
