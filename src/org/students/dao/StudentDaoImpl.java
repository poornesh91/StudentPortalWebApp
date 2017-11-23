package org.students.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.students.bean.CourseBean;
import org.students.bean.StudentBean;

public class StudentDaoImpl implements StudentDao {

	public boolean insertStudent(StudentBean student) {
		Connection connection = null;
		PreparedStatement statement = null;
		int noOfRecordsInserted = 0;
		ResultSet generatedKeys = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			statement = connection.prepareStatement(INSERT_INTO_STUDENT.toString());
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getSsn());
			noOfRecordsInserted = statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
            	student.setId(generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("Creating Student failed.");
            }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (generatedKeys != null) {
					generatedKeys.close();
				}
				if (statement != null) {
					statement.close();
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
	
	public List<StudentBean> findAllStudents(){
		Connection connection = null;
		PreparedStatement statement = null;
		List<StudentBean> studentBeans = new ArrayList<StudentBean>();
		ResultSet resultSet = null;
		StudentBean studentBean = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
			statement = connection.prepareStatement(SELECT_ALL_STUDENTS.toString());
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				studentBean=new StudentBean();
				studentBean.setId(resultSet.getLong("ID"));
				studentBean.setFirstName(resultSet.getString("FIRST_NAME"));
				studentBean.setLastName(resultSet.getString("LAST_NAME"));
				studentBean.setSsn(resultSet.getString("SSN"));
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
