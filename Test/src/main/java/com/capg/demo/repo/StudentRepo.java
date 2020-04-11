package com.capg.demo.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.capg.demo.model.Student;

@Repository
public class StudentRepo  {

	Map<Integer,Student >  map = new HashMap<>();
	
	public StudentRepo() {
		
		Student  e1= new Student(1001,"John",LocalDate.of(1996, 02, 25));
		Student  e2= new Student(1002,"John",LocalDate.of(1996, 02, 25));
		map.put(1001, e1);
		map.put(1002, e2);
	}
	
	public List<Student> findall() {
		Collection<Student> values = map.values();
		List<Student>   list = new ArrayList<>(values);
		return list;
	}

	public Student   findStudentByName(String studentName)
	{
		return map.get(studentName);
	}
	
	public  Student deleteStudentByName(String studentName)
	{
		return  map.remove(studentName);
	}
	
	public Student  addStudent(Student student)
	{
		map.put(student.getStudentId(), student);
		
		return student ;
	}
}
