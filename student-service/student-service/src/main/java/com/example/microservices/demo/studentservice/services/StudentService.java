package com.example.microservices.demo.studentservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.microservices.demo.studentservice.beans.requests.StudentRequest;
import com.example.microservices.demo.studentservice.beans.responses.AddressResponse;
import com.example.microservices.demo.studentservice.beans.responses.StudentResponse;
import com.example.microservices.demo.studentservice.entities.Student;
import com.example.microservices.demo.studentservice.feignclients.AddressFeignClient;
import com.example.microservices.demo.studentservice.feignclients.ApiGatewayFeignClient;
import com.example.microservices.demo.studentservice.repositories.StudentRepository;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
//	@Autowired
//	AddressFeignClient addressFeignClient;
	
	@Autowired
	ApiGatewayFeignClient apiGatewayFeignClient;
	
	@Autowired
	WebClient webClient;

	public List<StudentResponse> getAllStudents() {
		return studentRepository.findAll().stream().map(StudentResponse::new).collect(Collectors.toList());
	}

	public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
		Student student = new Student();
		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
		student.setEmail(studentRequest.getEmail());
		student.setAddressId(studentRequest.getAddressId());
		student = studentRepository.save(student);
		StudentResponse studentResponse = new StudentResponse(student);
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(apiGatewayFeignClient.getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getStudentById(long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(apiGatewayFeignClient.getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
	public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse> addressReMono = webClient.get().uri("/api/addresses/" + addressId).retrieve().bodyToMono(AddressResponse.class);
		return addressReMono.block();
	}
}
