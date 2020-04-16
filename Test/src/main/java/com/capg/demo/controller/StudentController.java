package com.capg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.demo.model.Student;
import com.capg.demo.service.StudentService;
 
@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired(required=false)
	StudentService StudentService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){	
		return new ResponseEntity<List<Student>>(StudentService.getAllStudents(),HttpStatus.OK);
	}
	
	
	@GetMapping("/student/id/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId) {
		return new ResponseEntity<Student>(StudentService.getStudentById(studentId),HttpStatus.OK);
	}
	
	
	@GetMapping("/student/name/{name}")
	public ResponseEntity<Student> getStudentByName(@PathVariable("name") String studentName) {
		
		return new ResponseEntity<Student>(StudentService.getStudentByName(studentName),HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		
		return new ResponseEntity<Student>(StudentService.addStudent(student),HttpStatus.OK);
	}

	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		
		return new ResponseEntity<Student>(StudentService.updateStudent(student),HttpStatus.OK);
		
	}

	@DeleteMapping("/student/id/{id}")
	public boolean deleteById(@PathVariable("id") int studentId) {
		
			return StudentService.deleteById(studentId);
		
	}
}