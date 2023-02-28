package com.example.microservices.demo.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservices.demo.studentservice.beans.responses.AddressResponse;

//@FeignClient(url = "${address.service.url}", value = "address-feign-client", path = "/api/addresses")
//@FeignClient(value = "address-service", path = "/api/addresses")
public interface AddressFeignClient {

//	@GetMapping("/{id}")
//	public AddressResponse getAddressById(@PathVariable long id);

}
