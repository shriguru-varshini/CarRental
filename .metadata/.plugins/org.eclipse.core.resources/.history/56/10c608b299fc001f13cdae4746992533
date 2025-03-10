package com.CarRentalSystem.CarRental.Controllers;

import com.CarRentalSystem.CarRental.Models.User;
import com.CarRentalSystem.CarRental.Services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/phone/{phone}")
    public Optional<User> getUserByPhone(@PathVariable String phone) {
        return userService.getUserByPhone(phone);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/admin")
    public User addAdmin(@RequestBody User user) {
        return userService.addAdmin(user);
    }

    @PostMapping("/customer")
    public User addCustomer(@RequestBody User user) {
        return userService.addCustomer(user);
    }
    
    @GetMapping("/role/{role}")
    public List<User> getUserByRole(@PathVariable String role) {
        return userService.getUserByRole(role);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
