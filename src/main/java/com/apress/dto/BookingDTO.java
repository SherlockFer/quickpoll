package com.apress.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

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

	@ApiModelProperty(required = true)
	@NotNull
	private LocalDate date;

	private String comments;

}
