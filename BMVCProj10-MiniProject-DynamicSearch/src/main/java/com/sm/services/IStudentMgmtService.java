package com.sm.services;

import java.util.List;

import com.sm.model.Student;

public interface IStudentMgmtService {
	public String registerStudent(Student stu);
	public List<Student> showAllStudent();
	public Student getStudentbyid(int id);
	public String updateStudent(Student stu);
	
	public List<Student> showEmployeeReportWithDynamicSearch(Student stu);
	
}
