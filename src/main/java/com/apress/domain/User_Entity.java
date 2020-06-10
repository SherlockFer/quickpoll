package com.apress.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User_Entity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "FULL_NAME")
	private String full_name;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "PASSWORD")
	private String password;

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
