package com.apress.dto;

import java.time.LocalDate;
import java.util.Set;

import com.apress.domain.Part;
import com.apress.domain.Product;
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

	@JsonProperty("status")
	private String status;

	@JsonProperty("service_ids")
	private Set<Product> products;

	@JsonProperty("part_ids")
	private Set<Part> parts;

	private LocalDate date;

	private String comments;

}
