package com.apress.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.apress.dto.PartDTO;

@Component
public class PartValidator {

	public void validate(PartDTO bookingDTO) {
		validateComments(bookingDTO);
	}

	private void validateComments(PartDTO bookingDTO) {
		if (StringUtils.isBlank(bookingDTO.getSku())) {
			bookingDTO.addError("sku can't be empty");
		}
	}

}
