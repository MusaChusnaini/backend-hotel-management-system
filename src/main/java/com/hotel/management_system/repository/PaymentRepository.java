package com.hotel.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management_system.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}