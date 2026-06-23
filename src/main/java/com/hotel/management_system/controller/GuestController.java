package com.hotel.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management_system.model.Guest;
import com.hotel.management_system.repository.GuestRepository;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "*")
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
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails) {
        return guestRepository.findById(id).map(guest -> {
            guest.setfullName(guestDetails.getfullName());
            guest.setnikOrPassport(guestDetails.getnikOrPassport());
            guest.setphoneNumber(guestDetails.getphoneNumber());
            guest.setEmail(guestDetails.getEmail());
            return guestRepository.save(guest);
        }).orElseThrow(() -> new RuntimeException("Tamu tidak ditemukan dengan id: " + id));
    }
    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable Long id) {
        if (!guestRepository.existsById(id)) {
            throw new RuntimeException("Tamu tidak ditemukan dengan id: " + id);
        }
        guestRepository.deleteById(id);
        return "Tamu dengan ID " + id + " berhasil dihapus dari database!";
    }
}
