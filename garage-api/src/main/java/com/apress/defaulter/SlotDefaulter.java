package com.apress.defaulter;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.apress.dto.SlotDTO;

@Component
public class SlotDefaulter {

	public void populateDefaults(SlotDTO TimeSlotDTO) {
		populateReference(TimeSlotDTO);
	}

	public void populateReference(SlotDTO TimeSlotDTO) {
	}

}