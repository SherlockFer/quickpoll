package com.apress.service.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.apress.domain.User_Entity;
import com.apress.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public UserDTO toUserDTO(User_Entity user);

	public User_Entity toUser(UserDTO userDTO);

	public Collection<UserDTO> toUserDTOs(Collection<User_Entity> users);

}
