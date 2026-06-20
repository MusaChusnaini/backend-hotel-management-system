package com.hotel.management_system.controller;

import com.hotel.management_system.model.Guest;
import com.hotel.management_system.repository.FacilityRepository;
import com.hotel.management_system.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }
    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

}
