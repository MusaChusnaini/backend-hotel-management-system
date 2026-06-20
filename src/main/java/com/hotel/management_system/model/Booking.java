package com.hotel.management_system.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "status", nullable = false)
    private String status;

    // Constructor Kosong (Wajib JPA)
    public Booking() {}

    // Constructor Berparameter
    public Booking(Long id, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, BigDecimal totalAmount, String status) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // --- GETTER & SETTER ---
    public Long getId() {
        return id;
    }
    public Guest getGuest() {
        return guest;
    }
    public Room getRoom() {
        return room;
    }
    public LocalDate getCheckInDate() {
        return checkInDate;
    }
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}