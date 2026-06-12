package com.hotel.management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management_system.model.RoomType;
import com.hotel.management_system.repository.RoomTypeRepository;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @GetMapping
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @PostMapping
    public RoomType createRoomType(@RequestBody RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }
}