package com.example.microservices.demo.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservices.demo.studentservice.beans.responses.AddressResponse;

@FeignClient(value = "api-gateway")
public interface ApiGatewayFeignClient {
	
	@GetMapping("/address-service/api/addresses/{id}")
	public AddressResponse getAddressById(@PathVariable long id);


}
