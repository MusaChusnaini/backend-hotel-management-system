package com.hotel.management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_facilities")
public class BookingFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // Constructor Kosong
    public BookingFacility() {}

    // Constructor Parameter
    public BookingFacility(Long id, Booking booking, Facility facility, Integer quantity) {
        this.id = id;
        this.booking = booking;
        this.facility = facility;
        this.quantity = quantity;
    }

    // --- GETTER & SETTER ---
    public Long getId() {
        return id;
    }
    public Booking getBooking() {
        return booking;
    }
    public Facility getFacility() {
        return facility;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public void setFacility(Facility facility) {
        this.facility = facility;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
