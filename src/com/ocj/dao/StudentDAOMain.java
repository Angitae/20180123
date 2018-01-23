package com.ocj.dao;

public class StudentDAOMain {
	public static void main(String[] args) {
		StudentDAO dao = new StudentFileDAO();
		
		dao.addStudent(null);
		dao.modifyStudent(null);
		dao.removeStudent(0);
		dao.getStudent(0);
		dao.getStudentList();
	}
}
