package org.avco.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.students.bean.StudentBean;
import org.students.service.StudentCoursesService;
import org.students.service.StudentCoursesServiceImpl;

public class GetAllStudentCoursesController extends HttpServlet{

final static StudentCoursesService studentCoursesService  = new StudentCoursesServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<StudentBean> studentBeans = studentCoursesService.fetchAllStudentCourses();
		request.setAttribute("STUDENT_LIST", studentBeans);
		RequestDispatcher rd = request.getRequestDispatcher("ViewStudentCourses.jsp");
		rd.forward(request, response);
	}
}
