package com.apress.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.apress.dto.UserDTO;

@Component
public class UserValidator {

	public void validate(UserDTO userDTO) {
		validateEmail(userDTO);
	}

	private void validateEmail(UserDTO userDTO) {
		if (StringUtils.isBlank(userDTO.getEmail())) {
			userDTO.addError("Email can't be empty");
		}
	}

}
