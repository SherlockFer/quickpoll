package com.apress.dto;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Builder(toBuilder = true)
@Setter
@Getter

public class BookingDTO extends BaseDTO {

	private Long id;

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

	@JsonProperty("base_product")
	private ProductDTO baseProduct;

	@Singular(ignoreNullCollections = true)
	@JsonProperty("extra_products")
	private Set<ProductDTO> extraProducts;

	@Singular(ignoreNullCollections = true)
	@JsonProperty("parts")
	private Set<PartDTO> parts;

	@JsonProperty("mechanic")
	private UserDTO mechanic;

	@JsonProperty("customer")
	private UserDTO customer;

	@JsonProperty("date")
	private LocalDate date;

	@JsonProperty("comments")
	private String comments;

	@JsonIgnore
	private String countryCode;

	@JsonProperty("total")
	private Double total;

	@JsonProperty("vat_number")
	private String vatNumber;

	@JsonIgnore
	private String ipSource;

	@JsonIgnore
	private String ipCountry;

	@JsonIgnore
	private String ipCity;
}
