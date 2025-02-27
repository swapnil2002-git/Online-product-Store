package com.sm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sm.model.Student;
import com.sm.services.IStudentMgmtService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentMgmtService stuService;
	
	@GetMapping
	public String showIndexPage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String registerStudentPage(@ModelAttribute("stu") Student stu)
	{
		return "show_registration_page";
	}
	
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("stu") Student stu,  RedirectAttributes attrs)
	{
		String msg = stuService.registerStudent(stu);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	
	@GetMapping("/report")
	public String showStudents(Map<String, Object> map , @ModelAttribute("stu") Student stu)
	{
		List<Student> list = stuService.showAllStudent();
		map.put("list", list);
		return "show_report";
	}
	
	@GetMapping("/stu_edit")
	public String editStudentDetails( @RequestParam("no") Integer no , @ModelAttribute("stu") Student stu ) {
		
		// use service
		Student stu1 = stuService.getStudentbyid(no);
		// copy data
		BeanUtils.copyProperties(stu1, stu);

		return "update_student";
	}
	
	@PostMapping("/stu_edit")
	public String editStudent(RedirectAttributes attrs, @ModelAttribute("stu") Student stu)
	{
		String msg = stuService.updateStudent(stu);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@PostMapping("/search")
	public String showReportDynamicSearch(@ModelAttribute("stu") Student stu, Map<String, Object> map)
	{
		List<Student> list = stuService.showEmployeeReportWithDynamicSearch(stu);
		
		map.put("list", list);
		
		return "show_report";
	}
	
	
}
