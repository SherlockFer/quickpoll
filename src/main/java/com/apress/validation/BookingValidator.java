package com.apress.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.apress.dto.BookingDTO;

@Component
public class BookingValidator {
	
	public void validate(BookingDTO bookingDTO) {
		validateComments(bookingDTO);
	}

	private void validateComments(BookingDTO bookingDTO) {
		if(StringUtils.isBlank(bookingDTO.getComments())) {
			bookingDTO.getErrors().add("Comments can't be empty");
		}
	}

}
