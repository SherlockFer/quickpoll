package com.apress.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
@Setter
@Getter

public class PartDTO extends BaseDTO {

	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("price")
	private Integer price;

	@JsonIgnore
	private String sku;

}