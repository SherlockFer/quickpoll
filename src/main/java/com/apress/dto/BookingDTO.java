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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
