package com.apress.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class VehiclePlateProducer {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	private String queue = "garage.vehicule.plate";

	public void sendVehiclePlate(String vehiclePlate) {
		log.info("Sending Vehicle Plate details: {} " + vehiclePlate);
		redisTemplate.convertAndSend(queue, vehiclePlate);
	}

}
