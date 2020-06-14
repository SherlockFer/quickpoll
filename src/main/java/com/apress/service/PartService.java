package com.apress.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.domain.Part;
import com.apress.dto.PartDTO;
import com.apress.repository.PartRepository;
import com.apress.service.mappers.PartMapper;

@Service
public class PartService {
	@Autowired
	private PartRepository partRepository;
	@Autowired
	private PartMapper partMapper;

	public Collection<PartDTO> findAll() {
		Collection<Part> parts = partRepository.findAll();
		return partMapper.toPartDTOs(parts);
	}

	public Optional<PartDTO> findById(long id) {
		Optional<Part> Part = partRepository.findById(id);
		if (Part.isPresent()) {
			return Optional.of(partMapper.toPartDTO(Part.get()));
		}
		return Optional.empty();
	}

	public PartDTO save(PartDTO PartDTO) {
		Part Part = partRepository.save(partMapper.toPart(PartDTO));
		return partMapper.toPartDTO(Part);
	}

	public void deleteById(Long id) {
		partRepository.deleteById(id);
	}
}
