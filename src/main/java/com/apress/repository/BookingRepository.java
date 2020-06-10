package com.apress.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apress.domain.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}