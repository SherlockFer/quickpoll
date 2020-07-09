package com.apress.service.defaulter;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apress.client.GeoLocationClient;
import com.apress.dto.BookingDTO;

import garage.services.geolocation.types.GetLocationRequest;
import garage.services.geolocation.types.GetLocationResponse;

@Component
public class BookingDefaulter {

	@Autowired
	private GeoLocationClient client;

	public void populateDefaults(BookingDTO bookingDTO) {
		populateReference(bookingDTO);
		populateCountryAndCity(bookingDTO);
	}

	public void populateReference(BookingDTO bookingDTO) {
		bookingDTO.setReference(UUID.randomUUID().toString());
	}

	public void populateCountryAndCity(BookingDTO bookingDTO) {
		GetLocationRequest getLocationRequest = new GetLocationRequest();
		getLocationRequest.setIp(bookingDTO.getIpSource());
		GetLocationResponse getLocationResponse = client.getLocation(getLocationRequest);
		bookingDTO.setIpCountry(getLocationResponse.getCountry());
		bookingDTO.setIpCity(getLocationResponse.getCity());
	}
}
