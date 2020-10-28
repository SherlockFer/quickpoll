package com.apress.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.apress.domain.Slot;
import com.apress.dto.SlotDTO;

@Mapper(componentModel = "spring")
public interface SlotMapper {

	public SlotDTO toSlotDTO(Slot slot);

	public Slot toSlot(SlotDTO slotDTO);

	public Collection<SlotDTO> toSlotDTOs(Collection<Slot> slots);

}
