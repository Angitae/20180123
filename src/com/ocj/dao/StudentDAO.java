package com.ocj.dao;

import java.util.List;

// DAO (Data Access Object) 클래스
// => DataSource(파일, Dbms등)에 데이터를 저장, 변경, 삭제, 검색 등의
//      기능을 제공하는 클래스.
// = > DAO 인터페이스를 상속받아 유지보수의 효율성 증가
// = > DataSource가 변경되어도 Application에 영향이 적게 받도록
//        결합도(의존성)을 낮춰 유지보수의 효율성 증가

public interface StudentDAO {
	//학생정보를 전달받아 DataSource에 저장하여 결과를 반환하는 메소드 
	int addStudent(StudentDTO student);
	int modifyStudent(StudentDTO student);
	int removeStudent(int num);
	StudentDTO getStudent(int num);
	List<StudentDTO> getStudentList();
}
