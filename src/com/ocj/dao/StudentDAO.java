package com.ocj.dao;

import java.util.List;

// DAO (Data Access Object) Ŭ����
// => DataSource(����, Dbms��)�� �����͸� ����, ����, ����, �˻� ����
//      ����� �����ϴ� Ŭ����.
// = > DAO �������̽��� ��ӹ޾� ���������� ȿ���� ����
// = > DataSource�� ����Ǿ Application�� ������ ���� �޵���
//        ���յ�(������)�� ���� ���������� ȿ���� ����

public interface StudentDAO {
	//�л������� ���޹޾� DataSource�� �����Ͽ� ����� ��ȯ�ϴ� �޼ҵ� 
	int addStudent(StudentDTO student);
	int modifyStudent(StudentDTO student);
	int removeStudent(int num);
	StudentDTO getStudent(int num);
	List<StudentDTO> getStudentList();
}
