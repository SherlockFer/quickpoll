package com.apress.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.apress.domain.Booking;
import com.apress.repository.BookingRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Component
public class LoadDemoData implements ApplicationRunner {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Loading database");
		bookingRepository.save(Booking.builder().comments("test1").build());
		bookingRepository.save(Booking.builder().comments("test2").build());
	}

}
