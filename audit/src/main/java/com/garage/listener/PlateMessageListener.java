package com.garage.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.garage.dto.AuditDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class PlateMessageListener {

	@RabbitListener(queues = "garage.vehicle.plate")
	public void receiveMessage(final AuditDTO auditDTO) {
		log.info("Received message: {}", auditDTO);
		RestTemplate restTemplate = new RestTemplate();
		String a = restTemplate.postForObject("https://httpbin.org/post", auditDTO, String.class);
		log.info("String: {}", a);
	}

}
