package com.jrm.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jrm.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	


	/*Get All data
	 * 
	 * @GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Jyoti", "Ranjan"));
		theStudents.add(new Student("Smruti", "Ranjan"));
		theStudents.add(new Student("Raj", "Ranjan"));
		
		
		return theStudents;
		
	}*/
	
	
	//get specific student data
	List<Student> theStudents;
	
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Jyoti", "Ranjan"));
		theStudents.add(new Student("Smruti", "Ranjan"));
		theStudents.add(new Student("Raj", "Ranjan"));
		
	
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		
		//check the studentId exists
		if((studentId>=theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student Not Found - "+studentId);
		}
		
		
		return theStudents.get(studentId);
	}
	
	//add exception handler
	
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorresponse> handleException(StudentNotFoundException e){
		//create student error response
		
		StudentErrorresponse errorresponse = new StudentErrorresponse();
		
		errorresponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorresponse.setMessage(e.getMessage());
		errorresponse.setTimestamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(errorresponse,HttpStatus.NOT_FOUND);
		
		//return response entity
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorresponse> handleanyException(Exception e){
		//create student error response
		
		StudentErrorresponse errorresponse = new StudentErrorresponse();
		
		errorresponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorresponse.setMessage(e.getMessage());
		errorresponse.setTimestamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(errorresponse,HttpStatus.BAD_REQUEST);
		
		//return response entity
		
	}

}
	
	
	
	
