package com.CarRentalSystem.CarRental.Controllers;

import com.CarRentalSystem.CarRental.Models.*;
import com.CarRentalSystem.CarRental.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceInterface paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getPaymentsByUserId(@PathVariable Long userId) {
        return paymentService.getPaymentsByUserId(userId);
    }

    @PostMapping
    public Payment processPayment(@RequestParam Long reservationId, @RequestParam String paymentMethod) {
        return paymentService.processPayment(reservationId, paymentMethod);
    }
}
