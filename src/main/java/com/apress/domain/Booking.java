package com.apress.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "VEHICULE_NUMBER_PLATE")
	private String vehicule_number_plate;

	@Column(name = "VEHICULE_MODEL")
	private String vehicule_model;

	@Column(name = "VEHICULE_BRAND")
	private String vehicule_brand;

	@Column(name = "VEHICULE_ENGINE")
	private String vehicule_engine;

	@Column(name = "DATE")
	private String date;

	@Column(name = "COMMENTS")
	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicule_number_plate() {
		return vehicule_number_plate;
	}

	public void setVehicule_number_plate(String vehicule_number_plate) {
		this.vehicule_number_plate = vehicule_number_plate;
	}

	public String getVehicule_model() {
		return vehicule_model;
	}

	public void setVehicule_model(String vehicule_model) {
		this.vehicule_model = vehicule_model;
	}

	public String getVehicule_brand() {
		return vehicule_brand;
	}

	public void setVehicule_brand(String vehicule_brand) {
		this.vehicule_brand = vehicule_brand;
	}

	public String getVehicule_engine() {
		return vehicule_engine;
	}

	public void setVehicule_engine(String vehicule_engine) {
		this.vehicule_engine = vehicule_engine;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}