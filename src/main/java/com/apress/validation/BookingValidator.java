package com.apress.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.apress.client.VatServiceClient;
import com.apress.dto.BookingDTO;

import eu.europa.ec.taxud.vies.services.checkvat.types.CheckVat;
import eu.europa.ec.taxud.vies.services.checkvat.types.CheckVatResponse;

@Component
public class BookingValidator {

	VatServiceClient client;

	public void validate(BookingDTO bookingDTO) {
		validateComments(bookingDTO);
		validateVehiculeNumberPlate(bookingDTO);
		validateStatus(bookingDTO);
		validateVatNumber(bookingDTO);
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

	private void validateVatNumber(BookingDTO bookingDTO) {
		if (!StringUtils.isBlank(bookingDTO.getVatNumber())) {
			CheckVat checkVat = new CheckVat();
			checkVat.setCountryCode(bookingDTO.getCountryCode());
			checkVat.setVatNumber(bookingDTO.getVatNumber());
			try {
				CheckVatResponse checkVatResponse = client.checkVat(checkVat);
				if (!checkVatResponse.isValid()) {
					bookingDTO.addError("invalid vatNumber");
				}
			} catch (RuntimeException exception) {
				exception.printStackTrace();
			}

		}
	}

}
