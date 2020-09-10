package com.apress.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@PostMapping(value = "/token")
	public ResponseEntity<Map> login(String email, String password) {
		Map<String, String> res = new HashMap<String, String>();
		res.put("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0LCJyb2xlIjoiY3VzdG9tZXIiLCJmdWxsX25hbWUiOiJDdXN0b21lci0xIn0.Na1kXMpa6C2p4jayU40itxVqzFnoyZqq0CuOZ8v--b0");
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
