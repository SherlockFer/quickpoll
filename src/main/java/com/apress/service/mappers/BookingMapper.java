package com.apress.service.mappers;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apress.domain.Booking;
import com.apress.dto.BookingDTO;

@Component
public class BookingMapper {

	@Autowired
	private ModelMapper modelMapper;

	public BookingDTO toBookingDTO(Booking booking) {
		return modelMapper.map(booking, BookingDTO.class);
	}

	public Booking toBooking(BookingDTO bookingDTO) {
		return modelMapper.map(bookingDTO, Booking.class);
	}

	public Collection<BookingDTO> toBookingDTOs(Collection<Booking> bookings) {
		return bookings.stream().map(booking -> toBookingDTO(booking)).collect(Collectors.toList());
	}

}
