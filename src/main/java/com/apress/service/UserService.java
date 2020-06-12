package com.apress.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.domain.User;
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
		Collection<User> users = userRepository.findAll();
		return userMapper.toUserDTOs(users);
	}

	public Optional<UserDTO> findUser(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return Optional.of(userMapper.toUserDTO(user.get()));
		}
		return Optional.empty();
	}

	public void saveUser(UserDTO userDTO) {
		User user = userMapper.toUser(userDTO);
		userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}