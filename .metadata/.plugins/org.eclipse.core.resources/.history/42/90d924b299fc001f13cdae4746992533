package com.CarRentalSystem.CarRental.Services.Impl;

import com.CarRentalSystem.CarRental.Models.*;
import com.CarRentalSystem.CarRental.Repositories.*;
import com.CarRentalSystem.CarRental.Services.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationServiceInterface {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> getReservationsByCarId(Long carId) {
        return reservationRepository.findByCarId(carId);
    }

    @Override
    public Reservation createReservation(Long userId, Long carId, Reservation reservation) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Car> carOptional = carRepository.findById(carId);

        if (userOptional.isEmpty() || carOptional.isEmpty()) {
            throw new RuntimeException("User or Car not found");
        }

        reservation.setUser(userOptional.get());
        reservation.setCar(carOptional.get());
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Long userId, Long carId, Reservation reservation) {
        Optional<Reservation> existingReservationOpt = reservationRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Car> carOptional = carRepository.findById(carId);

        if (existingReservationOpt.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }
        if (userOptional.isEmpty() || carOptional.isEmpty()) {
            throw new RuntimeException("User or Car not found");
        }

        Reservation existingReservation = existingReservationOpt.get();
        existingReservation.setUser(userOptional.get());
        existingReservation.setCar(carOptional.get());
        existingReservation.setStartDatetime(reservation.getStartDatetime());
        existingReservation.setEndDatetime(reservation.getEndDatetime());
        existingReservation.setStatus(reservation.getStatus());

        return reservationRepository.save(existingReservation);
    }

    @Override
    public void cancelReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
