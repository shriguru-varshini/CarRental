package com.CarRentalSystem.CarRental.Repositories;

import com.CarRentalSystem.CarRental.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByAvailability(Boolean availability);
    List<Car> findByType(String type);
}
