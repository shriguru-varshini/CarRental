package com.CarRentalSystem.CarRental.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private LocalDateTime startDatetime;

    @Column(nullable = false)
    private LocalDateTime endDatetime;

    @Column(nullable = false, length = 20)
    private String status = "PENDING"; // Example: "PENDING", "CONFIRMED", "CANCELLED"

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

	public Reservation() {
		super();
	}

	public Reservation(Long id, User user, Car car, LocalDateTime startDatetime, LocalDateTime endDatetime,
			String status, double totalPrice, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.car = car;
		this.startDatetime = startDatetime;
		this.endDatetime = endDatetime;
		this.status = status;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDateTime getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(LocalDateTime startDatetime) {
		this.startDatetime = startDatetime;
	}

	public LocalDateTime getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(LocalDateTime endDatetime) {
		this.endDatetime = endDatetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    
    // Getters and Setters
}
