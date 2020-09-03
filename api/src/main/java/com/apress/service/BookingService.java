package com.apress.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.domain.Booking;
import com.apress.domain.Part;
import com.apress.domain.Product;
import com.apress.dto.BookingDTO;
import com.apress.repository.BookingRepository;
import com.apress.sender.PlateMessageSender;
import com.apress.service.defaulter.BookingDefaulter;
import com.apress.service.mappers.BookingMapper;
import com.apress.validation.BookingValidator;

@Service

public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BookingMapper bookingMapper;
	@Autowired
	private BookingDefaulter bookingDefaulter;
	@Autowired
	private BookingValidator bookingValidator;
	@Autowired
	private PlateMessageSender plateMessageSender;

	public Collection<BookingDTO> findAll() {
		Collection<Booking> bookings = bookingRepository.findAll();
		Collection<BookingDTO> bookingDTO=bookingMapper.toBookingDTOs(bookings);
		calTotalManyBooking(bookingDTO);
		return bookingDTO;
	}

	public Optional<BookingDTO> findById(Long id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if (booking.isPresent()) {
			Optional<BookingDTO> bookingDTO= Optional.of(bookingMapper.toBookingDTO(booking.get()));
			calTotalOneBooking(bookingDTO);
			return bookingDTO;
		}
		return Optional.empty();
	}

	public boolean existsById(Long id) {
		return bookingRepository.existsById(id);
	}

	@Transactional
	public BookingDTO save(BookingDTO bookingDTO) {
		bookingDefaulter.populateDefaults(bookingDTO);
		bookingValidator.validate(bookingDTO);
		if (bookingDTO.hasErrors()) {
			return bookingDTO;
		}
		Booking booking = bookingRepository.save(bookingMapper.toBooking(bookingDTO));
		plateMessageSender.sendVehiclePlate(bookingMapper.toAuditDTO(booking));
		return bookingMapper.toBookingDTO(booking);
	}

	@Transactional
	public void deleteById(Long id) {
		bookingRepository.deleteById(id);
	}
	
	private void calTotalOneBooking(Optional<BookingDTO> bookingDTO) {
		BookingDTO booking =bookingDTO.get();
		booking.setTotal(calPriceProductParts(booking));
	}
	
	private void calTotalManyBooking(Collection<BookingDTO> bookingDTO) {
		for (BookingDTO booking : bookingDTO) {
			booking.setTotal(calPriceProductParts(booking));		
		}
	}
	
	private int calPriceProductParts(BookingDTO bookingDTO) {
		int baseProductPrice=getBaseProductPrice(bookingDTO);
		int extraProductsPrice=getExtraProductPrice(bookingDTO);
		int partsPrice=getPartsPrice(bookingDTO);
		return (baseProductPrice+extraProductsPrice+partsPrice);
	}

	private int getBaseProductPrice(BookingDTO booking) {
		return booking.getBaseProduct().getPrice();
	}
	
	private int getExtraProductPrice(BookingDTO booking) {
		int sum=0;
		for (Product extraProduct : booking.getExtraProducts()) {
			sum=sum+extraProduct.getPrice();
		}
		return sum;
	}
	
	private int getPartsPrice(BookingDTO booking) {
		int sum=0;
		for (Part part : booking.getParts()) {
			sum=sum+part.getPrice();
		}
		return sum;
	}
	
}