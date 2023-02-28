package com.example.microservices.demo.addressservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.demo.addressservice.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
