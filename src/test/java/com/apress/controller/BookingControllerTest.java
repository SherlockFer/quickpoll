package com.apress.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.apress.dto.BookingDTO;
import com.apress.service.BookingService;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

	@InjectMocks
	private BookingController controller;
	@Mock
	private BookingService bookingService;

	@Test
	public void shouldReturnAllBookingsWithHttpStatusOk() {
		BookingDTO bookingDTO = BookingDTO.builder().id(1L).comments("comment").build();
		when(bookingService.findAll()).thenReturn(Arrays.asList(bookingDTO));

		ResponseEntity<Collection<BookingDTO>> response = controller.getAllBookings();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().size()).isEqualTo(1);
	}

}