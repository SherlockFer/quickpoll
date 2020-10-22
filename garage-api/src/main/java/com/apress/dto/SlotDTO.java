package com.apress.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SlotDTO {

	private Long id;

	@JsonProperty("start_time")
	private LocalDateTime startTime;       

	@JsonProperty("end_time")
	private LocalDateTime endTime;
	
	public SlotDTO(long id) {
	    this.id = id;
	}

}
