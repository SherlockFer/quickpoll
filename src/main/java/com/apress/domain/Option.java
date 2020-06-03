package com.apress.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
// To declare this class is a database
@Entity
public class Option {
// to declare this is my primary key?
@Id
@GeneratedValue @Column(name="OPTION_ID") private Long id;
@Column(name="OPTION_VALUE") private String value;
    // Getters and Setters omitted for brevity
}