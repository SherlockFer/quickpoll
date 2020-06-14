package com.apress.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter

public class PartDTO {

	private Long id;

	private String name;

	private Integer price;

}