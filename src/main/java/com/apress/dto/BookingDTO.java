package com.apress.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDTO {

	private Long id;

	private String vehiculeNumberPlate;

	private String vehiculeModel;

	@JsonProperty("vehicule_brand")
	private String vehiculeBrand;

	private String vehiculeEngine;

	private LocalDate date;

	private String comments;

}
