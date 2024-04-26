package com.shankar.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shankar.sm.beans.Student;
import com.shankar.sm.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService; 
	
	@GetMapping("/getStudentsList")
//	@RequestMapping(value = "/getStudentsList",method = RequestMethod.GET)
	public String showStudentsList(Model model) {
		
	List<Student> studentList = studentService.loadStudents();
	model.addAttribute("students", studentList);

		return "Students-List";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student student) {


		return "Add-Student";
	}
	
	@PostMapping("/save-student")
//	@RequestMapping(value = "/save-student",method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		System.out.println(student);
		if (student.getId()==0) {
			studentService.saveStudent(student);
		}
		else {
			studentService.updateStudent(student);
		}
		return "redirect:/getStudentsList";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userid") int id, Model model) {

		Student student = studentService.getStudent(id);
		model.addAttribute("student", student);
		
		return "Update-Student";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userid") int id) {

		studentService.deleteStudent(id);
		
		return "redirect:/getStudentsList";
	}
	
}
