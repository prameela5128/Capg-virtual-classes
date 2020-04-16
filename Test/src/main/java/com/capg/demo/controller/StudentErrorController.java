package com.capg.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.demo.exceptions.EmptyStudentListException;
import com.capg.demo.exceptions.StudentAlreadyExistsException;
import com.capg.demo.exceptions.StudentNotFoundException;


@RestController
@ControllerAdvice
public class StudentErrorController {
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found" , code = HttpStatus.NOT_FOUND)
	public void handleUserNotFoundException() {
		
	}
	@ExceptionHandler(StudentAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Student Already Exists" , code = HttpStatus.ALREADY_REPORTED)
	public void handleStudentAlreadyExistException() {
		
	}
	@ExceptionHandler(EmptyStudentListException.class)
	@ResponseStatus(value = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, reason = "No Student Found" , code = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
	public void handleEmptyStudentListException() {
		
	}
	
}
