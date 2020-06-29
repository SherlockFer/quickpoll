package com.apress.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.apress.dto.BookingDTO;

@Component
public class BookingValidator {

	public void validate(BookingDTO bookingDTO) {
		validateComments(bookingDTO);
		validateVehiculeNumberPlate(bookingDTO);
		validateStatus(bookingDTO);
	}

	private void validateComments(BookingDTO bookingDTO) {
		if (StringUtils.isBlank(bookingDTO.getComments())) {
			bookingDTO.addError("Comments can't be empty");
		}
	}

	private void validateVehiculeNumberPlate(BookingDTO bookingDTO) {
		if (StringUtils.isBlank(bookingDTO.getVehiculeNumberPlate())) {
			bookingDTO.addError("Vehicule number plate can't be empty");
		}
	}

	private void validateStatus(BookingDTO bookingDTO) {
		if (StringUtils.isBlank(bookingDTO.getStatus())) {
			bookingDTO.addError("Status can't be empty");
		}
	}

}
