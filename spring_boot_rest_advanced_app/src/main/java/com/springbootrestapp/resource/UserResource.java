package com.springbootrestapp.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapp.entities.User;
import com.springbootrestapp.exception.UserNotFoundException;
import com.springbootrestapp.service.UserDaoService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping
	public List<User> getUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) throws UserNotFoundException {
		return userDaoService.findOne(id);
	}
	
	@PostMapping
	public EntityModel<User> saveUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		//HATEOAS
		EntityModel<User> entityModel = EntityModel.of(savedUser);
		WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).getUsers());
		entityModel.add(webMvcLinkBuilder.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {
		User user = userDaoService.findOne(id);
		if(user != null)
			userDaoService.delete(id);
	}
	
}
