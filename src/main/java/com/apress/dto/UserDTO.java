package com.apress.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserDTO {

	private Long id;

	private String fullName;

	private String mobile;

	private String email;

	private String role;

	private String password;

}
