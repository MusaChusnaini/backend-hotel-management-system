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
@Table(name = "rooms") 
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "room_number", nullable = false, unique = true) 
    private String roomNumber;

    // UBAH BAGIAN INI: Dari Long jadi objek RoomType dengan relasi ManyToOne
    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;

    @Column(nullable = false) 
    private String status = "AVAILABLE";

    public Room() {}

    // Sesuaikan parameternya di constructor
    public Room(Long id, String roomNumber, RoomType roomType, String status) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    // Sesuaikan Getter & Setter untuk RoomType objek
    public RoomType getRoomType() { return roomType; }
    public void setRoomType(RoomType roomType) { this.roomType = roomType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}