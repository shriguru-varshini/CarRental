package com.CarRentalSystem.CarRental.Repositories;

import com.CarRentalSystem.CarRental.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);
    List<Payment> findByPaymentStatus(String paymentStatus);
    Optional<Payment> findByTransactionId(String transactionId);
}
