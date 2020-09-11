package com.apress.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apress.service.UserService;
import com.apress.dto.TokenDTO;
import com.apress.dto.UserDTO;
import com.apress.jwt.JwtUtils;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping(value = "/token")
	public ResponseEntity<TokenDTO> login(String email, String password) {
		UserDTO userDTO = userService.findById(1).get(); //Example for Admin
		String jwtToken = jwtUtils.createJwtToken(userDTO);
		TokenDTO tokenDTO=TokenDTO.builder()
				.token(jwtToken)
				.build();
		return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
	}

}
