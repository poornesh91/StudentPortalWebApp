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

public class CourseDaoImpl implements CourseDao{

	@Override
	public boolean insertCourse(CourseBean course) {
		Connection connection = null;
		PreparedStatement statement = null;
		int noOfRecordsInserted = 0;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			statement = connection.prepareStatement(INSERT_INTO_COURSE.toString());
			statement.setString(1, course.getCode());
			statement.setString(2, course.getName());
			statement.setString(3, course.getDescription());
			statement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			noOfRecordsInserted = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		return noOfRecordsInserted>0?true:false;
	}

	@Override
	public boolean editCourse(CourseBean course) {
		Connection connection = null;
		PreparedStatement statement = null;
		int noOfRecordsInserted = 0;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			statement = connection.prepareStatement(EDIT_INTO_COURSE.toString());
			statement.setString(1, course.getCode());
			statement.setString(2, course.getName());
			statement.setString(3, course.getDescription());
			statement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			noOfRecordsInserted = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		return noOfRecordsInserted>0?true:false;
	}
	public List<CourseBean> findAllCourses(){
		Connection connection = null;
		PreparedStatement statement = null;
		List<CourseBean> courseBeans = new ArrayList<CourseBean>();
		ResultSet resultSet = null;
		CourseBean courseBean = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			statement = connection.prepareStatement(SELECT_ALL_COURSES.toString());
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				courseBean=new CourseBean();
				courseBean.setId(resultSet.getLong("ID"));
				courseBean.setCode(resultSet.getString("CODE"));
				courseBean.setName(resultSet.getString("NAME"));
				courseBean.setDescription(resultSet.getString("DESCRIPTION"));
				courseBean.setCreationDate(resultSet.getDate("CREATE_DT"));
				courseBeans.add(courseBean);
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
		return courseBeans;
	}
}
