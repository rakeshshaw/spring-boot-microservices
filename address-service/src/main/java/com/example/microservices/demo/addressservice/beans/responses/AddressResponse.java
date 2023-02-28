package com.example.microservices.demo.addressservice.beans.responses;

import com.example.microservices.demo.addressservice.entities.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

	private long addressId;
	private String street;
	private String city;

	public AddressResponse(Address address) {
		this.addressId = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
	}

}
