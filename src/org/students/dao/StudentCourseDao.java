package org.students.dao;

import java.util.List;

import org.students.bean.StudentBean;
import org.students.bean.StudentCourseBean;

public interface StudentCourseDao extends EntityDao{

	public static final StringBuilder INSERT_INTO_STUDENT_COURSE = new StringBuilder("INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID,START_DT,END_DT,CREATE_DT) "
			+ " VALUES(?,?,?,?,?)");
	
	
	public static final StringBuilder SELECT_ALL_STUDENT_COURSES = new StringBuilder("select t1.ID as STUDENT_ID, t1.FIRST_NAME,t1.LAST_NAME,t3.NAME "
			+ " from STUDENT t1, STUDENT_COURSE t2,COURSE t3 where t1.ID = t2.STUDENT_ID and t2.COURSE_ID = t3.ID");
			
	public boolean insertStudentCourse(List<StudentCourseBean> studentCourseBeans);
	
	public List<StudentBean> findAllStudentCourses();
}
