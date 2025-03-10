package com.CarRentalSystem.CarRental.Services;

import com.CarRentalSystem.CarRental.Models.*;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByPhone(String phone);
    Optional<User> login(String email, String password);
    List<User> getUserByRole(String role);
    User addUser(User user);
    User addAdmin(User user);
    User addCustomer(User user);
    User updateUser(Long id, User user); // Added updateUser method
    void deleteUser(Long id);
}
