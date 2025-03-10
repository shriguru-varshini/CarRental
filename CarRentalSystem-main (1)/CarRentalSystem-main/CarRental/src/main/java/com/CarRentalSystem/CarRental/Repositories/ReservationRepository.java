package com.CarRentalSystem.CarRental.Repositories;

import com.CarRentalSystem.CarRental.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByCarId(Long carId);
    List<Reservation> findByStatus(String status);
}
