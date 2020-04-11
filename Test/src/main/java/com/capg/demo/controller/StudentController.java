package com.capg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import org.springframework.web.bind.annotation.RestController;

import com.capg.demo.model.Student;
import com.capg.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService  Service ;
	
	  @GetMapping("student")
	public  List<Student>  getAllStudents()
	{
		  return Service.findall();
				  
	}
	@GetMapping("student/{name}") 
	public Student  findStudentsByName(@PathVariable("name") String studentName)
	{
		  return Service.findStudentByName(studentName);
	}
	
	@DeleteMapping("student/{name}") 
	public Student  deleteStudentByName(@PathVariable("name") String studentName)
	{
		  return Service.deleteStudentByName(studentName);
	}
	
	@PostMapping("student") 
	public Student  addStudentByName(@RequestBody Student  student)
	{
		  return Service.addStudent(student);
	}
	
	
}
