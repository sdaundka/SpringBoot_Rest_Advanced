package com.springbootrestapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springbootrestapp.entities.User;
import com.springbootrestapp.exception.UserNotFoundException;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Ram", new Date()));
		users.add(new User(2, "Shyam", new Date()));
		users.add(new User(3, "Ghanshyam", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) throws UserNotFoundException {
		for (User user : users) {
			if(user.getId() == id)
				return user;
		}
		throw new UserNotFoundException("User with id : "+id + " is not found.");
	}
	
	public User save(User user) {
		if(user.getId() == 0) {
			int length = users.size();
			user.setId(++length);
		}
		users.add(user);
		return user;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
			}
		}
	}
	
}
