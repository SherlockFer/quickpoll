package com.apress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apress.domain.Slot;

@Repository
public interface TimeSlotRepository extends JpaRepository<Slot, Long> {

}