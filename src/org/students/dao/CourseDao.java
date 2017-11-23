package org.students.dao;

import java.util.List;

import org.students.bean.CourseBean;

public interface CourseDao extends EntityDao{

	public static final StringBuilder INSERT_INTO_COURSE = new StringBuilder("INSERT INTO COURSE(CODE,NAME,DESCRIPTION,CREATE_DT) VALUES(?,?,?,?)");
	
	public static final StringBuilder EDIT_INTO_COURSE = new StringBuilder("EDIT INTO COURSE(CODE,NAME,DESCRIPTION,CREATE_DT) VALUES(?,?,?,?)");
	
	public static final StringBuilder SELECT_ALL_COURSES = new StringBuilder("SELECT ID,CODE,NAME,CREATE_DT,DESCRIPTION FROM COURSE");
	
	public boolean insertCourse(CourseBean course);
	public boolean editCourse(CourseBean course);
	
	public List<CourseBean> findAllCourses();
}
