package com.apress.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.apress.domain.Product.ProductBuilder;
import com.apress.domain.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "SLOT")
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "slot_id_seq")
	@SequenceGenerator(name = "slot_id_seq", sequenceName = "slot_id_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "START_TIME")
	private LocalDateTime startTime;
	
	@Column(name = "END_TIME")
	private LocalDateTime endTime;
	
	@Column(name = "CREATED_AT", insertable = true, updatable = false)
	private LocalDateTime created;

	@Column(name = "MODIFIED_AT")
	private LocalDateTime modified;

	@PrePersist
	void onCreate() {
		this.setCreated(LocalDateTime.now());
		this.setModified(LocalDateTime.now());
	}

	@PreUpdate
	void onUpdate() {
		this.setModified(LocalDateTime.now());
	}

	public Slot(LocalDateTime startTime,LocalDateTime endTime) {
		this.startTime=startTime;
		this.endTime=endTime;
	}
	
}
