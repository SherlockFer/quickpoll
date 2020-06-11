package com.apress.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Booking {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "VEHICULE_NUMBER_PLATE")
	private String vehiculeNumberPlate;

	@Column(name = "VEHICULE_MODEL")
	private String vehiculeModel;

	@Column(name = "VEHICULE_BRAND")
	private String vehiculeBrand;

	@Column(name = "VEHICULE_ENGINE")
	private String vehiculeEngine;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "COMMENTS")
	private String comments;

}