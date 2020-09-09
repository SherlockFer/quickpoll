package com.apress.defaulter;

import org.springframework.stereotype.Component;

import com.apress.dto.UserDTO;
import com.apress.utils.WebConstants;

@Component
public class UserDefaulter {

	public void populateDefaults(UserDTO userDTO) {
		populateRole(userDTO);
	}

	public void populateRole(UserDTO userDTO) {
		if (userDTO.getRole() == null) {
			userDTO.setRole(WebConstants.USER_ROLE_CUSTOMER);
		}
	}

}
