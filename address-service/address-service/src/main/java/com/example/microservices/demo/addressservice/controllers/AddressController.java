package com.example.microservices.demo.addressservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.demo.addressservice.beans.requests.AddressRequest;
import com.example.microservices.demo.addressservice.beans.responses.AddressResponse;
import com.example.microservices.demo.addressservice.services.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@GetMapping("/")
	public List<AddressResponse> getAllAddressess(){
		return addressService.getAll();
	}
	
	@GetMapping("/{id}")
	public AddressResponse getAddressById(@PathVariable long id){
		System.out.println("LoadBalancer Testing...");
		return addressService.getById(id);
	}
	
	@PostMapping("/")
	public AddressResponse create(@RequestBody AddressRequest addressRequest){
		return addressService.create(addressRequest);
	}
	
}
