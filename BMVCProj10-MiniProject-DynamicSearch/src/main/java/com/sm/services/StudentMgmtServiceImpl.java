package com.sm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.sm.model.Student;
import com.sm.repository.IStudentRepository;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	
	@Autowired
	private IStudentRepository stuRepo;

	@Override
	public String registerStudent(Student stu) {
		Integer ids = stuRepo.save(stu).getSid();
		return "Student registered successfully with id "+ids;
	}

	@Override
	public List<Student> showAllStudent() {
		List<Student> studentList = stuRepo.findAll();
		return studentList;
	}

	@Override
	public Student getStudentbyid(int id) {
		
		Student stu = stuRepo.findById(id).orElseThrow(()-> new IllegalArgumentException());
		return stu;
	}

	@Override
	public String updateStudent(Student stu) {
		
		Integer id = stuRepo.save(stu).getSid();
		
		return  "Student details updated successfully with id  "+id;
	}
	
	@Override
	public List<Student> showEmployeeReportWithDynamicSearch(Student stu) {

		// replace empty string with null values 
		
		if(stu.getName().equalsIgnoreCase("") || stu.getName().length()==0)
		{
			stu.setName(null);
		}
		
		if(stu.getDept().equalsIgnoreCase("")|| stu.getDept().length()==0)
		{
			stu.setDept(null);
		}
		
		// prepare example object having student object
		Example<Student> example = Example.of(stu);
		List<Student> listofStudent = stuRepo.findAll(example);
		
		return listofStudent;
	}

}
