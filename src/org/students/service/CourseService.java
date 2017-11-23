package org.students.service;

import java.util.List;

import org.students.bean.CourseBean;

public interface CourseService {

	boolean addCourse(CourseBean course) throws Exception;
	boolean editCourse(CourseBean course) throws Exception;

	
	public List<CourseBean> findAllCourses();
}
