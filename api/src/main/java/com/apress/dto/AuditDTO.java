package com.apress.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
@Setter
@Getter
public class AuditDTO implements Serializable {

	@JsonProperty("bokking_id")
	private Long id;

	@JsonProperty("vehicule_number_plate")
	private String vehiculeNumberPlate;

}
