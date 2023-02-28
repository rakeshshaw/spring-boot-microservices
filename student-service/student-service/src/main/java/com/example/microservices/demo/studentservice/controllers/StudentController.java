package com.example.microservices.demo.studentservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.demo.studentservice.beans.requests.StudentRequest;
import com.example.microservices.demo.studentservice.beans.responses.StudentResponse;
import com.example.microservices.demo.studentservice.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public List<StudentResponse> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/")
	public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
		return studentService.createStudent(studentRequest);
	}
	
	@GetMapping("/{id}")
	public StudentResponse getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	

}
