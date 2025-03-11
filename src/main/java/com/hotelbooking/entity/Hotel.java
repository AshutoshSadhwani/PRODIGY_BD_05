package com.hotelbooking.entity;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String location;
	private double price;
	private boolean available;
	
//	@JsonManagedReference  // 🔹 Prevents infinite recursion
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	@JsonIgnoreProperties({"username", "password",
		"email", "role", "hotels"}) // 🔹 Ignore unnecessary fields
	private User owner;

	
	
	
}
