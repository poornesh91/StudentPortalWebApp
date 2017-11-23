package org.avco.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.students.bean.CourseBean;
import org.students.service.CourseService;
import org.students.service.CourseServiceImpl;

public class StudentCoursesController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	final static CourseService courseService = new CourseServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<CourseBean> courseBeans = courseService.findAllCourses();
		request.setAttribute("COURSE_LIST", courseBeans);
		RequestDispatcher rd = request.getRequestDispatcher("AddStudent.jsp");
		rd.forward(request, response);
	}
}
