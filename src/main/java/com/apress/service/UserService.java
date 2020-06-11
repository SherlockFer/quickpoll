package com.apress.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.domain.User_Entity;
import com.apress.dto.UserDTO;
import com.apress.repository.UserRepository;
import com.apress.service.mappers.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	public Collection<UserDTO> findAll() {
		Collection<User_Entity> users = userRepository.findAll();
		return userMapper.toUserDTOs(users);
	}

}