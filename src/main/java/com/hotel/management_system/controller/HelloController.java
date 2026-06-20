package com.hotel.management_system.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management_system.model.Room;
import com.hotel.management_system.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/api/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    @GetMapping("/api/rooms/{id}") 
        public Optional<Room> getRoomById(@PathVariable Long id) {
            return roomRepository.findById(id);
        }
        @PostMapping("/api/rooms")
        public Room createRoom(@RequestBody Room room) {
            return roomRepository.save(room);
        }
        @DeleteMapping("/api/rooms/{id}")
        public String deleteRoom(@PathVariable Long id) {
            roomRepository.deleteById(id);
            return "Kamar dengan ID " + id + " berhasil dihapus dari database.";
        }
    }
