package org.students.dao;

import java.util.List;

import org.students.bean.StudentBean;

public interface StudentDao extends EntityDao{

	public static final StringBuilder INSERT_INTO_STUDENT = new StringBuilder("INSERT INTO STUDENT(FIRST_NAME,LAST_NAME,SSN) VALUES(?,?,?)");
	
	public static final StringBuilder SELECT_ALL_STUDENTS = new StringBuilder("SELECT ID,FIRST_NAME,LAST_NAME,SSN FROM STUDENT");
	
	public boolean insertStudent(StudentBean student);
	
	public List<StudentBean> findAllStudents();
}
