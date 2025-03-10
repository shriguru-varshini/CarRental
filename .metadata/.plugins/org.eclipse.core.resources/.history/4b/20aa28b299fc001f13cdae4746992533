package com.CarRentalSystem.CarRental.Services;

import com.CarRentalSystem.CarRental.Models.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationServiceInterface {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
    List<Reservation> getReservationsByUserId(Long userId);
    List<Reservation> getReservationsByCarId(Long carId);
    Reservation createReservation(Long userId, Long carId, Reservation reservation);
    Reservation updateReservation(Long id, Long userId, Long carId, Reservation reservation); // Updated method signature
    void cancelReservation(Long id);
}
