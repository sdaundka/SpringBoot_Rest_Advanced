package com.springbootrestapp.resource.contentnegotiation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapp.entities.Student;

@RestController
@RequestMapping("/content-negotiate")
public class StudentResource {

	@GetMapping
	public Student getStudent() {
		Student student = new Student(101, "Abc", "IN");
		return student;
	}
	
}
