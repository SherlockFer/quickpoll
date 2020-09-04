package com.apress.dto;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
@Setter
@Getter

public class BookingDTO extends BaseDTO {

	private Long id;

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("vehicle_number_plate")
	private String vehicleNumberPlate;

	@JsonProperty("vehicle_model")
	private String vehicleModel;

	@JsonProperty("vehicle_brand")
	private String vehicleBrand;

	@JsonProperty("vehicle_engine")
	private String vehicleEngine;

	@JsonProperty("vehicle_type")
	private String vehicleType;

	@JsonProperty("status")
	private String status;

	@JsonProperty("service_id")
	private ProductDTO baseProduct;

	@JsonProperty("service_ids")
	private Set<ProductDTO> extraProducts;

	@JsonProperty("part_ids")
	private Set<PartDTO> parts;

	@JsonProperty("mechanic_id")
	private UserDTO mechanic;

	@JsonProperty("customer_id")
	private UserDTO customer;

	private LocalDate date;

	private String comments;

	private String countryCode;

	private Double total;

	private String vatNumber;

	@JsonIgnore
	private String ipSource;

	@JsonIgnore
	private String ipCountry;

	@JsonIgnore
	private String ipCity;
}
