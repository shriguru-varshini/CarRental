package com.CarRentalSystem.CarRental.Repositories;

import com.CarRentalSystem.CarRental.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    List<User> findByRole(String role);
    Optional<User> findByEmailAndPassword(String email, String password); // Login method


}
