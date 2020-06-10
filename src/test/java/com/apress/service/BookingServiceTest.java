package com.apress.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apress.domain.Booking;
import com.apress.dto.BookingDTO;
import com.apress.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

	@InjectMocks
	private BookingService service;

	@Mock
	private BookingRepository bookingRepository;

	@Test
	void testFindAll() {
		Booking booking = new Booking();
		booking.setId(1L);
		when(bookingRepository.findAll()).thenReturn(Arrays.asList(booking));

		Iterable<BookingDTO> bookingDTOs = service.findAll();

		assertThat(bookingDTOs.iterator().next().getId()).isEqualTo(1L);
	}

}
