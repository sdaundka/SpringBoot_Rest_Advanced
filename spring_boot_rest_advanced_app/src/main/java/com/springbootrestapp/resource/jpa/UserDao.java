package com.springbootrestapp.resource.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer>{

}
