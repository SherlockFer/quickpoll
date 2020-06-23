package com.apress.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.apress.dto.ProductDTO;

@Component
public class ProductValidator {

	public void validate(ProductDTO productDTO) {
		validateName(productDTO);
	}

	private void validateName(ProductDTO productDTO) {
		if (StringUtils.isBlank(productDTO.getName())) {
			productDTO.addError("Name can't be empty");
		}
	}

}
