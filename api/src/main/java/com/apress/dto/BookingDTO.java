package com.apress.dto;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

	@OneToOne
	@JsonProperty("base_product")
	private ProductDTO baseProduct;

	@Singular(ignoreNullCollections = true)
	@ManyToMany
	@JsonProperty("extra_products")
	private Set<ProductDTO> extraProducts;

	@Singular(ignoreNullCollections = true)
	@ManyToMany
	@JsonProperty("parts")
	private Set<PartDTO> parts;

	@ManyToOne
	@JsonProperty("mechanic")
	private UserDTO mechanic;

	@ManyToOne
	@JsonProperty("customer")
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
