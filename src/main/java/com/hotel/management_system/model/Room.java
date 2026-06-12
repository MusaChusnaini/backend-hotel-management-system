package com.hotel.management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms") 
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "room_number", nullable = false, unique = true) 
    private String roomNumber;

    @Column(name = "room_type_id", nullable = false)
    private Long roomTypeId;

    @Column(nullable = false) 
    private String status = "AVAILABLE";

    //Constructor buat handle JPA
    public Room() {}

    public Room(Long id, String roomNumber, Long roomTypeId, String status) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomTypeId = roomTypeId;
        this.status = status;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Long getRoomTypeId() { return roomTypeId; }
    public void setRoomTypeId(Long roomTypeId) { this.roomTypeId = roomTypeId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}