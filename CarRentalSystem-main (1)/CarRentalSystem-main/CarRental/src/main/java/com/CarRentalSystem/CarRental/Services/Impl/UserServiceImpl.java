package com.CarRentalSystem.CarRental.Services.Impl;

import com.CarRentalSystem.CarRental.Models.User;
import com.CarRentalSystem.CarRental.Repositories.UserRepository;
import com.CarRentalSystem.CarRental.Services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByRole(String role) {
        return userRepository.findByRole(role);
    }
    
    public User addAdmin(User user) {
        user.setRole("admin"); // Hardcoded role
        return userRepository.save(user);
    }

    public User addCustomer(User user) {
        user.setRole("customer"); // Hardcoded role
        return userRepository.save(user);
    }
    
    @Override
    public Optional<User> login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setPassword(user.getPassword());
            return userRepository.save(updatedUser);
        }
        return null; // Handle case where user doesn't exist
    }
}
