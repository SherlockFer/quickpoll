package com.apress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apress.domain.Booking;
import com.apress.repository.BookingRepository;

@RestController
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Booking>> getAllBookings() {
		Iterable<Booking> allBookings = bookingRepository.findAll();
		return new ResponseEntity<>(allBookings, HttpStatus.OK);
	}

}