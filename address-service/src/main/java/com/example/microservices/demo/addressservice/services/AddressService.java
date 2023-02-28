package com.example.microservices.demo.addressservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.demo.addressservice.beans.requests.AddressRequest;
import com.example.microservices.demo.addressservice.beans.responses.AddressResponse;
import com.example.microservices.demo.addressservice.entities.Address;
import com.example.microservices.demo.addressservice.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public AddressResponse create(AddressRequest addressRequest) {
		Address address = new Address();
		address.setStreet(addressRequest.getStreet());
		address.setCity(addressRequest.getCity());
		addressRepository.save(address);
		return new AddressResponse(address);
	}

	public List<AddressResponse> getAll() {
		return addressRepository.findAll().stream().map(AddressResponse::new).collect(Collectors.toList());
	}

	public AddressResponse getById(long id) {
		return new AddressResponse(addressRepository.findById(id).get());
	}
}
