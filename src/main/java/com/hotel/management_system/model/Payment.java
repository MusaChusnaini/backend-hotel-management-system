package com.hotel.management_system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "amount_paid", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    // Constructor Kosong
    public Payment() {}

    // Constructor Parameter
    public Payment(Long id, Booking booking, String paymentMethod, BigDecimal amountPaid, LocalDateTime paymentDate) {
        this.id = id;
        this.booking = booking;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
    }

    // --- GETTER & SETTER ---
    public Long getId() {
        return id;
    }
    public Booking getBooking() {
        return booking;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public BigDecimal getAmountPaid() {
        return amountPaid;
    }
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}