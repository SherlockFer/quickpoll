package com.apress.jwt;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.apress.dto.UserDTO;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtils {

	@Value("${jwt.secret}")
	private String JWT_SECRET;
	
	public String createJwtToken(UserDTO userDTO) {
		Instant expirationTime = Instant.now().plus(1,ChronoUnit.HOURS);
		Date expirationDate = Date.from(expirationTime);
		
		Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());
		
		String jwtToken = Jwts.builder()
				.claim("user_id",userDTO.getId())
				.claim("role",userDTO.getRole())
				.claim("full_name",userDTO.getFullName())
				.setExpiration(expirationDate)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
		
		return jwtToken;
	}
}
