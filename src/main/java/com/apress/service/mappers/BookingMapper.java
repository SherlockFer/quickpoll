package com.apress.service.mappers;

import org.mapstruct.Mapper;

import com.apress.domain.Booking;
import com.apress.dto.BookingDTO;

@Mapper(componentModel = "spring")
public interface BookingMapper {

	BookingDTO toBookingDTO(Booking booking);

	Iterable<BookingDTO> toBookingDTOs(Iterable<Booking> bookings);

	Booking toBooking(BookingDTO bookingDTO);

}
