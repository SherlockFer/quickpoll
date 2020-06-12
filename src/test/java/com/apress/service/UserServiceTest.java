package com.apress.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apress.domain.User;
import com.apress.dto.UserDTO;
import com.apress.repository.UserRepository;
import com.apress.service.mappers.UserMapper;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService service;
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserMapper userMapper;

	@Test
	void testFindAll() {
		UserDTO userDTO = UserDTO.builder().id(1L).mobile("123456789").build();
		when(userRepository.findAll()).thenReturn(new ArrayList<User>());
		when(userMapper.toUserDTOs(any())).thenReturn(Arrays.asList(userDTO));

		Collection<UserDTO> userDTOs = service.findAll();

		assertThat(userDTOs.size()).isEqualTo(1);
	}

}

