package com.apress.service.defaulter;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.apress.dto.BookingDTO;

@Component
public class BookingDefaulter {
	
	public void populateDefaults(BookingDTO bookingDTO) {
		populateReference(bookingDTO);
	}
	
	public void populateReference(BookingDTO bookingDTO) {
		bookingDTO.setReference(UUID.randomUUID().toString());
	}
	
}
