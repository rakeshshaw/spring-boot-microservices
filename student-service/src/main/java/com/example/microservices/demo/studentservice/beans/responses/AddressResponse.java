package com.example.microservices.demo.studentservice.beans.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
	private long addressId;
	private String street;
	private String city;
}
