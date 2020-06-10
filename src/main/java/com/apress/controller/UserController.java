package com.apress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apress.domain.User_Entity;
import com.apress.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Iterable<User_Entity>> getAllPolls() {
		Iterable<User_Entity> allUsers = userRepository.findAll();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
}