package com.apress.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apress.domain.Booking;
import com.apress.dto.BookingDTO;
import com.apress.repository.BookingRepository;
import com.apress.service.mappers.BookingMapper;

@Service

public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BookingMapper bookingMapper;

	public Collection<BookingDTO> findAll() {
		Collection<Booking> bookings = bookingRepository.findAll();
		return bookingMapper.toBookingDTOs(bookings);
	}

	public Optional<BookingDTO> findById(long id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if (booking.isPresent()) {
			return Optional.of(bookingMapper.toBookingDTO(booking.get()));
		}
		return Optional.empty();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public BookingDTO save(BookingDTO bookingDTO) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {
		}
		Booking booking = this.doSave(bookingDTO);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {
		}
		return bookingMapper.toBookingDTO(booking);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Booking doSave(BookingDTO bookingDTO) {
		Booking booking = bookingRepository.save(bookingMapper.toBooking(bookingDTO));
		return booking;
	}

	public void deleteById(Long id) {
		bookingRepository.deleteById(id);
	}

}
