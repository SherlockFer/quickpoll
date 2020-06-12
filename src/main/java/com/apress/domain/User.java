package com.apress.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "PASSWORD")
	private String password;

}
