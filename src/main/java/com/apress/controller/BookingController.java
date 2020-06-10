package com.apress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apress.dto.BookingDTO;
import com.apress.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping(value = "/bookings")
	public ResponseEntity<Iterable<BookingDTO>> getAllBookings() {
		Iterable<BookingDTO> bookingDTOs = bookingService.findAll();
		return new ResponseEntity<>(bookingDTOs, HttpStatus.OK);
	}

}