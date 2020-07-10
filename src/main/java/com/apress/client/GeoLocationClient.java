package com.apress.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

import garage.services.geolocation.types.GetLocationRequest;
import garage.services.geolocation.types.GetLocationResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class GeoLocationClient {

	private WebServiceTemplate webServiceTemplate;

	@Autowired
	public GeoLocationClient() {
		this.webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setDefaultUri("http://localhost:8081/ws");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("garage.services.geolocation.types");
		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);
	}

	public GetLocationResponse getLocation(GetLocationRequest getLocationRequest) {
		GetLocationResponse getLocationResponse = null;
		try {
			getLocationResponse = (GetLocationResponse) webServiceTemplate.marshalSendAndReceive(getLocationRequest);
		} catch (SoapFaultClientException sfe) {
			log.warn("Geolocation Service fault", sfe.getMessage());
		} catch (RuntimeException e) {
			log.error("Geolocation Service error", e);
		}
		return getLocationResponse;
	}
}
