package org.students.service;

import java.util.List;

import org.students.bean.StudentBean;
import org.students.dao.StudentCourseDao;
import org.students.dao.StudentCourseDaoImpl;

public class StudentCoursesServiceImpl implements StudentCoursesService{

	StudentCourseDao studentCourseDao = new StudentCourseDaoImpl();
	
	@Override
	public List<StudentBean> fetchAllStudentCourses() {
		return studentCourseDao.findAllStudentCourses();
	}

}
