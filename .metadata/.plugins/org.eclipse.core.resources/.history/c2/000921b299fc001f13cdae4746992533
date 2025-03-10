package com.CarRentalSystem.CarRental.Services.Impl;

import com.CarRentalSystem.CarRental.Models.*;
import com.CarRentalSystem.CarRental.Repositories.*;
import com.CarRentalSystem.CarRental.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarServiceInterface {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAvailableCars() {
        return carRepository.findByAvailability(true);
    }

    @Override
    public List<Car> getCarsByType(String type) {
        return carRepository.findByType(type);
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        if (carRepository.existsById(id)) {
            car.setId(id);
            return carRepository.save(car);
        }
        return null;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
