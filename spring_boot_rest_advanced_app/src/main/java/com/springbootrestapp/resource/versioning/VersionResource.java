package com.springbootrestapp.resource.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapp.entities.Employee1;
import com.springbootrestapp.entities.Employee2;

@RestController
@RequestMapping("/versions")
public class VersionResource {

	//Using different end points for different versions
	@GetMapping("/1")
	public Employee1 getEmployee1() {
		Employee1 employee1 = new Employee1(201, "Abc", "US");
		return employee1;
	}
	
	@GetMapping("/2")
	public Employee2 getEmployee2() {
		Employee2 employee2 = new Employee2(301, "Pqr", "Xyz","IN");
		return employee2;
	}
	
	//Using same endpoints but with different request params
	@GetMapping(value = "/params", params = "version=1")
	public Employee1 getEmployee1ParamVersion1() {
		Employee1 employee1 = new Employee1(201, "Def", "US");
		return employee1;
	}
	
	@GetMapping(value = "/params", params = "version=2")
	public Employee2 getEmployee1ParamVersion2() {
		Employee2 employee2 = new Employee2(301, "Ghi", "Jkl","IN");
		return employee2;
	}
	
	//Using the same endpoints but with different request header to specify the custom version
	@GetMapping(value = "/header", headers = "version=1")
	public Employee1 getEmployee1HeaderVersion1() {
		Employee1 employee1 = new Employee1(501, "Mno", "UK");
		return employee1;
	}
	
	@GetMapping(value = "/header", headers = "version=2")
	public Employee2 getEmployee1HeaderVersion2() {
		Employee2 employee2 = new Employee2(601, "Stu", "vwx","IN");
		return employee2;
	}
	
	//Using the same endpoint with different content negotiations
	@GetMapping(value = "/content-negotiate", produces = "application/vnd.api-v1+json")
	public Employee1 getEmployee1ContentNegotiate1() {
		Employee1 employee1 = new Employee1(501, "Mno", "UK");
		return employee1;
	}
	
	@GetMapping(value = "/content-negotiate", produces = "application/vnd.api-v2+json")
	public Employee2 getEmployee1ContentNegotiate2() {
		Employee2 employee2 = new Employee2(601, "Stu", "vwx","IN");
		return employee2;
	}
	
}
