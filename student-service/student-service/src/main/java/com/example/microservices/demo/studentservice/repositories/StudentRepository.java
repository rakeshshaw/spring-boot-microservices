package com.example.microservices.demo.studentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.demo.studentservice.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	
}
