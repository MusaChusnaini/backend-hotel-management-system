package com.hotel.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management_system.model.Payment;
import com.hotel.management_system.repository.PaymentRepository;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        // Otomatis set waktu pembayaran ke waktu sekarang jika dari frontend kosong
        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(java.time.LocalDateTime.now());
        }
        return paymentRepository.save(payment);
    }
}