package com.apress.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apress.domain.Booking;
import com.apress.dto.BookingDTO;
import com.apress.repository.BookingRepository;
import com.apress.service.mappers.BookingMapper;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

	@InjectMocks
	private BookingService service;

	@Mock
	private BookingRepository bookingRepository;
	@Mock
	private BookingMapper bookingMapper;

	@Test
	void testFindAll() {
		BookingDTO bookingDTO = BookingDTO.builder().id(1L).comments("comment").build();
		when(bookingRepository.findAll()).thenReturn(new ArrayList<Booking>());
		when(bookingMapper.toBookingDTOs(any())).thenReturn(Arrays.asList(bookingDTO));

		Collection<BookingDTO> bookingDTOs = service.findAll();

		assertThat(bookingDTOs.size()).isEqualTo(1);
	}

}
