package com.apress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apress.dto.UserDTO;
import com.apress.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<Iterable<UserDTO>> getAllUsers() {
		Iterable<UserDTO> userDTOs = userService.findAll();
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

}