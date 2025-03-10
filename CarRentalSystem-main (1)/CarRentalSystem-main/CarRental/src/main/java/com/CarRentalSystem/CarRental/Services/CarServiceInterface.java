package com.CarRentalSystem.CarRental.Services;

import com.CarRentalSystem.CarRental.Models.*;
import java.util.List;
import java.util.Optional;

public interface CarServiceInterface {
    List<Car> getAllCars();
    Optional<Car> getCarById(Long id);
    List<Car> getAvailableCars();
    List<Car> getCarsByType(String type);
    Car addCar(Car car);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}
