package com.CarRentalSystem.CarRental.Controllers;

import com.CarRentalSystem.CarRental.Models.Reservation;
import com.CarRentalSystem.CarRental.Services.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationServiceInterface reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @GetMapping("/car/{carId}")
    public List<Reservation> getReservationsByCarId(@PathVariable Long carId) {
        return reservationService.getReservationsByCarId(carId);
    }

    @PostMapping
    public Reservation createReservation(@RequestParam Long userId, @RequestParam Long carId, @RequestBody Reservation reservation) {
        return reservationService.createReservation(userId, carId, reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestParam Long userId, @RequestParam Long carId, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, userId, carId, reservation);
    }


    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
    }
}
