package com.apress.validation;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apress.dto.BookingDTO;

@ExtendWith(MockitoExtension.class)
public class BookingValidatorTest {

	@InjectMocks
	private BookingValidator validator;

	@Test
	void shouldHasErrorWhenCommentIsNotPresent() {
		BookingDTO bookingDTO = Mockito
				.spy(BookingDTO.builder().comments(" ").vehiculeNumberPlate("AAA-111").status("booked").build());

		validator.validate(bookingDTO);

		verify(bookingDTO).addError("Comments can't be empty");

	}

	@Test
	void shouldHasErrorWhenVehiculeNumberPlateIsNotPresent() {
		BookingDTO bookingDTO = Mockito
				.spy(BookingDTO.builder().comments("comment").vehiculeNumberPlate(" ").status("booked").build());

		validator.validate(bookingDTO);

		verify(bookingDTO).addError("Vehicule number plate can't be empty");
	}

	@Test
	void shouldHasErrorWhenStatusIsNotPresent() {
		BookingDTO bookingDTO = Mockito
				.spy(BookingDTO.builder().comments("comment").vehiculeNumberPlate("AAA-111").status(" ").build());

		validator.validate(bookingDTO);

		verify(bookingDTO).addError("Status can't be empty");
	}

}
