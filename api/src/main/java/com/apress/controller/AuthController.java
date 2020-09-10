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
				"eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJyb2xlIjoiYWRtaW4iLCJmdWxsX25hbWUiOiJBZG1pbmlzdHJhdG9yIn0.9xKCI00vzibf0sKFixDOXQLZC5lHUF9ugG43zEIvAG8");
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
