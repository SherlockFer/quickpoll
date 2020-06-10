package com.apress.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

	private Long id;

	private String full_name;

	private String mobile;

	private String email;

	private String role;

	private String password;

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
