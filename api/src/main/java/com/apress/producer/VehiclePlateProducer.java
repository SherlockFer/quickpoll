package com.apress.producer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class VehiclePlateProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RabbitListener(queues = "myQueue")
	public void sendVehiclePlate(String vehiclePlate) {
		log.info("Sending Vehicle Plate details: {} " + vehiclePlate);
		rabbitTemplate.convertAndSend("myQueue", vehiclePlate);
	}

}
