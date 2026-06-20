package com.hotel.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management_system.model.BookingFacility;
import com.hotel.management_system.repository.BookingFacilityRepository;

@RestController
@RequestMapping("/api/booking-facilities")
public class BookingFacilityController {

    @Autowired
    private BookingFacilityRepository bookingFacilityRepository;

    @GetMapping
    public List<BookingFacility> getAllBookingFacilities() {
        return bookingFacilityRepository.findAll();
    }

    @PostMapping
    public BookingFacility createBookingFacility(@RequestBody BookingFacility bookingFacility) {
        return bookingFacilityRepository.save(bookingFacility);
    }
}