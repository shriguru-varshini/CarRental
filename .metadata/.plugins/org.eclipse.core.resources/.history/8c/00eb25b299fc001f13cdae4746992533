package com.CarRentalSystem.CarRental.Services;

import com.CarRentalSystem.CarRental.Models.*;
import java.util.List;
import java.util.Optional;

public interface PaymentServiceInterface {
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
    List<Payment> getPaymentsByUserId(Long userId);
    
    // Updated method to take reservationId and paymentMethod instead of a Payment object
    Payment processPayment(Long reservationId, String paymentMethod);
}
