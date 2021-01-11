package com.springbootrestapp.resource.jpa;

import java.util.List;
import java.util.Optional;

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
import com.springbootrestapp.exception.UserNotFoundException;

@RestController
@RequestMapping("/users/jpa")
public class UserResourceJpa {

	@Autowired
	private UserDao userDao;
	
	@GetMapping
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) throws UserNotFoundException {
		Optional<User> userOptional = userDao.findById(id);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User with id : "+id + " is not found.");
		
		User user = userOptional.get();
		return user;
	}
	
	@PostMapping
	public EntityModel<User> saveUser(@Valid @RequestBody User user) {
		User savedUser = userDao.save(user);
		//HATEOAS
		EntityModel<User> entityModel = EntityModel.of(savedUser);
		WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResourceJpa.class).getUsers());
		entityModel.add(webMvcLinkBuilder.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {
		userDao.deleteById(id);
	}
	
}
