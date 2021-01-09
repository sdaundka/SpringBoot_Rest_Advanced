package com.springbootrestapp.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String sayHelloWorld() {
		return "Hello World";
	}
	
}
