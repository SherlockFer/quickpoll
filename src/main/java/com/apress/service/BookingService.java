package com.apress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.domain.Booking;
import com.apress.dto.BookingDTO;
import com.apress.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Iterable<BookingDTO> findAll() {
		return toBookingDTOs(bookingRepository.findAll());
	}

	private Iterable<BookingDTO> toBookingDTOs(Iterable<Booking> bookings) {
		List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();
		for (Booking booking : bookings) {
			BookingDTO bookingDTO = new BookingDTO();
			bookingDTO.setId(booking.getId());
			bookingDTO.setDate(booking.getDate());
			bookingDTOs.add(bookingDTO);
		}
		return bookingDTOs;
	}

}
