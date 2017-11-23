package org.students.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentBean {

	private Long id;
	private String firstName;
	private String lastName;
	private String ssn;
	private List<StudentCourseBean> studentCourseBeans = new ArrayList<StudentCourseBean>(1);
	private String courseName;
	
	public List<StudentCourseBean> getStudentCourseBeans() {
		return studentCourseBeans;
	}
	public void setStudentCourseBeans(List<StudentCourseBean> studentCourseBeans) {
		this.studentCourseBeans = studentCourseBeans;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
