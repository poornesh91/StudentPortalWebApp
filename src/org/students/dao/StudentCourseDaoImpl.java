package org.students.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.students.bean.CourseBean;
import org.students.bean.StudentBean;
import org.students.bean.StudentCourseBean;

public class StudentCourseDaoImpl implements StudentCourseDao {

	@Override
	public boolean insertStudentCourse(List<StudentCourseBean> studentCourseBeans) {
		Connection connection = null;
	    PreparedStatement stCrsStatement = null;
		int noOfRecordsInserted = 0;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			if(studentCourseBeans.size()>0){
				stCrsStatement = connection.prepareStatement(INSERT_INTO_STUDENT_COURSE.toString());
				for( StudentCourseBean studentCourseBean: studentCourseBeans){
					stCrsStatement.setLong(1,studentCourseBean.getStudentId() );
					stCrsStatement.setLong(2,studentCourseBean.getCourseId() );
					stCrsStatement.setDate(3, studentCourseBean.getStartDate());
					stCrsStatement.setDate(4, studentCourseBean.getEndDate());
					stCrsStatement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
					noOfRecordsInserted = stCrsStatement.executeUpdate();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stCrsStatement != null) {
					stCrsStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return noOfRecordsInserted>0?true:false;
	}
	
	
	public List<StudentBean> findAllStudentCourses(){
		Connection connection = null;
		PreparedStatement statement = null;
		List<StudentBean> studentBeans = new ArrayList<StudentBean>();
		ResultSet resultSet = null;
		StudentBean studentBean = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			statement = connection.prepareStatement(SELECT_ALL_STUDENT_COURSES.toString());
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				studentBean=new StudentBean();
				studentBean.setId(resultSet.getLong("STUDENT_ID"));
				studentBean.setFirstName(resultSet.getString("FIRST_NAME"));
				studentBean.setLastName(resultSet.getString("LAST_NAME"));
				studentBean.setCourseName(resultSet.getString("NAME"));
				studentBeans.add(studentBean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet!=null){
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentBeans;
	}

}
