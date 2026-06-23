package com.hotel.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // 1. Tambahkan import ini
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management_system.dto.BookingRequestDTO;
import com.hotel.management_system.model.Booking;
import com.hotel.management_system.repository.BookingRepository; // 2. Nanti buat file ini
import com.hotel.management_system.service.BookingService; // 3. Nanti buat file ini

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // 4. Deklarasikan BookingService di sini agar bisa dipanggil
    @Autowired
    private BookingService bookingService; 

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }
    
    @PostMapping("/checkout")
    public ResponseEntity<?> processCheckout(@RequestBody BookingRequestDTO request) {
        try {
            bookingService.processCompleteBooking(request);
            return ResponseEntity.ok().body("Booking Berhasil Disimpan");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}