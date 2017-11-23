package org.students.service;

import java.util.List;

import org.students.bean.StudentBean;
import org.students.dao.StudentCourseDao;
import org.students.dao.StudentCourseDaoImpl;
import org.students.dao.StudentDao;
import org.students.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService{

	StudentDao studentDao = new StudentDaoImpl();
	StudentCourseDao studentCourseDao = new StudentCourseDaoImpl();
	
	public boolean addStudent(StudentBean student){
		boolean success = studentDao.insertStudent(student);
		final long studentId = student.getId();
		student.getStudentCourseBeans().forEach((studentCourseBean) -> studentCourseBean.setStudentId(studentId));
		success = studentCourseDao.insertStudentCourse(student.getStudentCourseBeans());
		return success;
	}
	
	public List<StudentBean> findAllStudents(){
		return studentDao.findAllStudents();
	}
}
