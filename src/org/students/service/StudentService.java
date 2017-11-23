package org.students.service;

import java.util.List;

import org.students.bean.StudentBean;

public interface StudentService {

	boolean addStudent(StudentBean student);
	
	List<StudentBean> findAllStudents();
}
