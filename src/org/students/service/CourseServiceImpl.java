package org.students.service;

import java.util.List;

import org.students.bean.CourseBean;
import org.students.dao.CourseDao;
import org.students.dao.CourseDaoImpl;
import org.students.util.StringUtil;

public class CourseServiceImpl implements CourseService{

	final static CourseDao courseDao = new CourseDaoImpl(); 
	
	@Override
	public boolean addCourse(CourseBean course) throws Exception {
		//
		if(StringUtil.isEmpty(course.getName())){
			throw new Exception("Invalid Course Name");
		}
		return courseDao.insertCourse(course);
	}
	
	@Override
	public boolean editCourse(CourseBean course) throws Exception {
		//
		if(StringUtil.isEmpty(course.getName())){
			throw new Exception("Invalid Course Name");
		}
		return courseDao.insertCourse(course);
	}

	public List<CourseBean> findAllCourses(){
		return courseDao.findAllCourses();
	}
}
