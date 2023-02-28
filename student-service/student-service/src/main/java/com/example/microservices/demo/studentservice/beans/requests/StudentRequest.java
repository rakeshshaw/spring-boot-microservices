package com.example.microservices.demo.studentservice.beans.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

	private String firstName;
	private String lastName;
	private String email;
	private long addressId;

}
