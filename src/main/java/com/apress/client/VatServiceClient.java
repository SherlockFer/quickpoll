package com.apress.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import eu.europa.ec.taxud.vies.services.checkvat.types.CheckVat;
import eu.europa.ec.taxud.vies.services.checkvat.types.CheckVatResponse;

@Component
public class VatServiceClient {

	private WebServiceTemplate webServiceTemplate;

	@Autowired
	public VatServiceClient() {
		this.webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setDefaultUri("https://ec.europa.eu/taxation_customs/vies/services/checkVatService");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("eu.europa.ec.taxud.vies.services.checkvat.types");
		webServiceTemplate.setMarshaller(marshaller);
		webServiceTemplate.setUnmarshaller(marshaller);
	}

	public CheckVatResponse checkVat(CheckVat checkVat) {
		return (CheckVatResponse) webServiceTemplate.marshalSendAndReceive(checkVat);

	}
}
