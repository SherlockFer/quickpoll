package com.apress.service.mappers;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apress.domain.User_Entity;
import com.apress.dto.UserDTO;

@Component
public class UserMapper {

	@Autowired
	private ModelMapper modelMapper;

	public UserDTO toUserDTO(User_Entity user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public User_Entity toUser(UserDTO userDTO) {
		return modelMapper.map(userDTO, User_Entity.class);
	}

	public Collection<UserDTO> toUserDTOs(Collection<User_Entity> users) {
		return users.stream().map(user -> toUserDTO(user)).collect(Collectors.toList());
	}

}
