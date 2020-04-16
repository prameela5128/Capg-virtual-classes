package com.capg.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.capg.demo.model.Student;
import com.capg.demo.repo.StudentJpaRepo;
import com.capg.demo.exceptions.EmptyStudentListException;
import com.capg.demo.exceptions.StudentAlreadyExistsException;
import com.capg.demo.exceptions.StudentNotFoundException;

@Service
public class StudentService {
	
	@Autowired(required = false)
	StudentJpaRepo studentRepo;

	@Transactional
	public Student addStudent(Student student)
	{
		if(studentRepo.existsById(student.getStudentId()))
			throw new StudentAlreadyExistsException("Student with id : " +student.getStudentId()+" is Already Exist");
		return studentRepo.save(student);
	}
	
	public Student getStudentById(int studentId)
	{
		if(!studentRepo.existsById(studentId)) 
		{	
		   throw new StudentNotFoundException("Student with id "+studentId+" Not Found");
		}
	    return studentRepo.getOne(studentId);
	}
	
	public List<Student> getAllStudents()
	{
	    if(studentRepo.count()==0)
	    	throw new EmptyStudentListException("No Student Found in Student Database");
		return studentRepo.findAll();
	}
	
	@Transactional
	public Student getStudentByName(String studentName)
	{
	    return studentRepo.getByStudentName(studentName);	
	}
	
	@Transactional
	public Student updateStudent(Student student)
	{
		
		if(!studentRepo.existsById(student.getStudentId()))
			throw new StudentNotFoundException("Student with id : " +student.getStudentId()+" Not Found");
	
		Student newStudent=studentRepo.getOne(student.getStudentId());
		newStudent.setStudentName(student.getStudentName());
		newStudent.setDob(student.getDob());
		
		studentRepo.save(newStudent);
		return newStudent;
	}
	
	@Transactional
	public boolean deleteById(int studentId)
	{
		if(!studentRepo.existsById(studentId)) 
		{	
		   throw new StudentNotFoundException("Student with id "+studentId+" Not Found");
		}
		studentRepo.deleteById(studentId);
		return !studentRepo.existsById(studentId);
	}
	
}
