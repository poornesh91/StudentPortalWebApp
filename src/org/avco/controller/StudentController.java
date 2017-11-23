package org.avco.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.students.bean.CourseBean;
import org.students.bean.StudentBean;
import org.students.bean.StudentCourseBean;
import org.students.service.CourseService;
import org.students.service.CourseServiceImpl;
import org.students.service.StudentService;
import org.students.service.StudentServiceImpl;

public class StudentController extends HttpServlet {

	private static final long serialVersionUID = -2903208839350657705L;
	static final StudentService studentService = new StudentServiceImpl();
	final static CourseService courseService = new CourseServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		StudentBean student = new StudentBean();

		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setSsn(request.getParameter("ssn"));

		String courseIds[] = request.getParameterValues("courses");
		StudentCourseBean studentCourseBean = null;
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_YEAR, 60);
		for(int i=0;i<courseIds.length;i++){
			studentCourseBean = new StudentCourseBean();
			studentCourseBean.setCourseId(Long.parseLong(courseIds[i]));
			studentCourseBean.setStartDate(new Date(Calendar.getInstance().getTimeInMillis()));
			studentCourseBean.setEndDate(new Date(cal.getTimeInMillis()));
			studentCourseBean.setStartDate(new Date(Calendar.getInstance().getTimeInMillis()));
			student.getStudentCourseBeans().add(studentCourseBean);
		}
		
		try {
			boolean success = studentService.addStudent(student);
			List<CourseBean> courseBeans = courseService.findAllCourses();
			request.setAttribute("COURSE_LIST", courseBeans);
			RequestDispatcher rd = request.getRequestDispatcher("AddStudent.jsp");
			String message = null;
			if (success) {
				message = "Student Enrolled Successfully.";
				request.setAttribute("ACTION_KEY", "alert alert-success");
			} else {
				message = "Unable to enroll Student details due to internal Error";
				request.setAttribute("ACTION_KEY", "alert alert-danger");
			}
			request.setAttribute("ACTION_VALUE", message);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<StudentBean> studentBeans = studentService.findAllStudents();
		request.setAttribute("STUDENT_LIST", studentBeans);
		RequestDispatcher rd = request.getRequestDispatcher("ViewStudents.jsp");
		rd.forward(request, response);
	}
}
