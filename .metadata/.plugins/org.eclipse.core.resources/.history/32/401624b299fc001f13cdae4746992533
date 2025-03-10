
package com.CarRentalSystem.CarRental.Services.Impl;

import com.CarRentalSystem.CarRental.Models.*;
import com.CarRentalSystem.CarRental.Repositories.*;
import com.CarRentalSystem.CarRental.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentServiceInterface {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    @Override
    public Payment processPayment(Long reservationId, String paymentMethod) {
        // Fetch reservation details
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);

        if (reservationOptional.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }

        Reservation reservation = reservationOptional.get();

        // Create a new Payment object
        Payment payment = new Payment();
        payment.setReservation(reservation);
        payment.setUser(reservation.getUser()); // Assign user from reservation
        payment.setAmount(reservation.getTotalPrice()); // Use total price from reservation
        payment.setPaymentMethod(paymentMethod);
        payment.setPaymentStatus("Completed"); // Default status
        payment.setTransactionId("TXN" + System.currentTimeMillis()); // Generate unique transaction ID

        // Save payment in the database
        return paymentRepository.save(payment);
    }
}
