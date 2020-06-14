package com.apress.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter

public class BookingDTO {

	private Long id;

	@JsonProperty("vehicule_number_plate")
	private String vehiculeNumberPlate;

	@JsonProperty("vehicule_model")
	private String vehiculeModel;

	@JsonProperty("vehicule_brand")
	private String vehiculeBrand;

	@JsonProperty("vehicule_engine")
	private String vehiculeEngine;

	private LocalDate date;

	private String comments;

}
