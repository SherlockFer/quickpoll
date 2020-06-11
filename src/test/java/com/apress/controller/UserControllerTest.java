package com.apress.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.apress.dto.UserDTO;
import com.apress.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;

	@Test
	public void shouldReturnAllPost() {
		UserDTO userDTO = UserDTO.builder().id(1L).mobile("12345678").build();
		when(userService.findAll()).thenReturn(Arrays.asList(userDTO));

		ResponseEntity<Collection<UserDTO>> response = userController.getAllUsers();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.hasBody()).isTrue();
		assertThat(response.getBody().size()).isEqualTo(1);
	}

}

