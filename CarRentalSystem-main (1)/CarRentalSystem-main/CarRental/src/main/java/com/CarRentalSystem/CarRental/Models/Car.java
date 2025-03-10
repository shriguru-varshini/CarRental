package com.CarRentalSystem.CarRental.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String brand;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false, length = 20)
    private String type;  // Example values: "SEDAN", "SUV", "TRUCK"

    @Column(nullable = false)
    private double pricePerHour;

    @Column(nullable = false)
    private double pricePerDay;

    @Column(nullable = false)
    private double pricePerWeek;

    @Column(nullable = false, length = 20)
    private String fuelType; // Example: "PETROL", "DIESEL", "ELECTRIC"

    @Column(nullable = false, length = 20)
    private String transmission; // Example: "MANUAL", "AUTOMATIC"

    @Column(nullable = false)
    private Boolean availability = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

	public Car() {
	}

	public Car(Long id, String brand, String model, Integer year, String type, double pricePerHour, double pricePerDay,
			double pricePerWeek, String fuelType, String transmission, Boolean availability, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.type = type;
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.pricePerWeek = pricePerWeek;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.availability = availability;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public double getPricePerWeek() {
		return pricePerWeek;
	}

	public void setPricePerWeek(double pricePerWeek) {
		this.pricePerWeek = pricePerWeek;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    // Getters and Setters
	
    
}
