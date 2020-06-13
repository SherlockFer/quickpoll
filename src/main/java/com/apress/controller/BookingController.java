package com.apress.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apress.dto.BookingDTO;
import com.apress.exception.ResourceNotFoundException;
import com.apress.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping(value = "/bookings")
	public ResponseEntity<Collection<BookingDTO>> getAllBookings() {
		Collection<BookingDTO> bookingDTOs = bookingService.findAll();
		return new ResponseEntity<>(bookingDTOs, HttpStatus.OK);
	}

	protected void verifyBooking(Long bookingId) {
		Optional<BookingDTO> bookingDTO = bookingService.findBooking(bookingId);
		if (!bookingDTO.isPresent()) {
			throw new ResourceNotFoundException(String.format("Booking with id %s not found", bookingId));
		}

	}

	@GetMapping(value = "/bookings/{bookingId}")
	public ResponseEntity<BookingDTO> getBooking(@PathVariable Long bookingId) {
		verifyBooking(bookingId);
		Optional<BookingDTO> bookingDTO = bookingService.findBooking(bookingId);
		return new ResponseEntity<>(bookingDTO.get(), HttpStatus.OK);
	}

}