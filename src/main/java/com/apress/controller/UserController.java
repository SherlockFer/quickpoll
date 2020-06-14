package com.apress.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apress.dto.UserDTO;
import com.apress.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<Collection<UserDTO>> findAll() {
		Collection<UserDTO> userDTOs = userService.findAll();
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		Optional<UserDTO> userDTO = userService.findById(id);
		if (!userDTO.isPresent()) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userDTO.get(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {
		userDTO = userService.save(userDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(buildLocationUri(userDTO.getId()));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	private URI buildLocationUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
		if (!userService.findById(id).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		userDTO.setId(id);
		userService.save(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!userService.findById(id).isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}