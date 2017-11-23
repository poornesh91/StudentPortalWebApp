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

public class CourseController extends HttpServlet{

	private static final long serialVersionUID = -2903208839350657705L;
	final static CourseService courseService = new CourseServiceImpl();
	
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		CourseBean course = new CourseBean();
		course.setCode(request.getParameter("courseCode"));
		course.setName(request.getParameter("courseName"));
		course.setDescription(request.getParameter("courseDesc"));
		try {
			boolean success = courseService.addCourse(course);
			RequestDispatcher rd = request.getRequestDispatcher("AddCourse.jsp");
			String message =null;
			if(success){
				message = "Course Details Added Successfully.";
				request.setAttribute("ACTION_KEY", "alert alert-success");
			}else{
				message = "Unable to add Course details due to internal Error";
				request.setAttribute("ACTION_KEY", "alert alert-danger");
			}
			request.setAttribute("ACTION_VALUE", message);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<CourseBean> courseBeans = courseService.findAllCourses();
		request.setAttribute("COURSE_LIST", courseBeans);
		RequestDispatcher rd = request.getRequestDispatcher("ViewCourses.jsp");
		rd.forward(request, response);
	}
}
