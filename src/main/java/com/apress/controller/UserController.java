package com.apress.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apress.dto.UserDTO;
import com.apress.exception.ResourceNotFoundException;
import com.apress.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<Collection<UserDTO>> getAllUsers() {
		Collection<UserDTO> userDTOs = userService.findAll();
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	protected void verifyUser(Long userId) {
		UserDTO userDTO = userService.findUser(userId);
		if (userDTO == null) {
			throw new ResourceNotFoundException(String.format("Poll with id %s not found", userId));
		}
	}

	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) throws Exception {
		verifyUser(userId);
		UserDTO userDTO = userService.findUser(userId);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

}