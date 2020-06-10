package com.apress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.domain.User_Entity;
import com.apress.dto.UserDTO;
import com.apress.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<UserDTO> findAll() {
		return toUserDTOs(userRepository.findAll());
	}

	private Iterable<UserDTO> toUserDTOs(Iterable<User_Entity> users) {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User_Entity user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setFull_name(user.getFull_name());
			userDTO.setEmail(user.getEmail());

			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

}