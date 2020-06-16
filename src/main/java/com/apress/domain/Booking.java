package com.apress.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "BOOKINGS")
public class Booking {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "VEHICULE_NUMBER_PLATE")
	private String vehiculeNumberPlate;

	@Column(name = "VEHICULE_MODEL")
	private String vehiculeModel;

	@Column(name = "VEHICULE_BRAND")
	private String vehiculeBrand;

	@Column(name = "VEHICULE_ENGINE")
	private String vehiculeEngine;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "STATUS")
	private String status;

	@Singular
	@ManyToMany
	@JoinTable(name = "BOOKING_PRODUCTS",
			   joinColumns = @JoinColumn(name = "BOOKING_ID"), 
			   inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private Set<Product> extraProducts;

	@Singular
	@ManyToMany
	@JoinColumn(name = "PART_ID")
	private Set<Part> parts;

	@OneToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product baseProduct;

	@OneToOne
	@JoinColumn(name = "MECHANIC_ID")
	private User mechanic;

	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private User customer;

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

}