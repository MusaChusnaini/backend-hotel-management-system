package com.hotel.management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    @Column(name = "full_name", nullable = false )
        private String fullName;
    
    @Column(name = "nik_or_passport", nullable = false)
        private String nikOrPassport;

    @Column(name = "phone_number", nullable = false)
        private String phoneNumber;

    @Column(name = "email", nullable = false) 
        private String email;

    public Guest() {}

    public Guest(Long id, String fullName, String nikOrPassport, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.nikOrPassport = nikOrPassport;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public String getfullName() {
        return fullName;
    }
    public String getnikOrPassport() {
        return nikOrPassport;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
    public void setnikOrPassport(String nikOrPassport) {
        this.nikOrPassport = nikOrPassport;
    }
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.time.LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(java.time.LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    @jakarta.persistence.Column(name = "created_at", updatable = false)
    private java.time.LocalDateTime createdAt;

    @jakarta.persistence.Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @jakarta.persistence.PrePersist
    protected void onCreate() {
        this.createdAt = java.time.LocalDateTime.now();
        this.updatedAt = java.time.LocalDateTime.now();
    }
    @jakarta.persistence.PreUpdate
    protected void onUpdate() {
        this.updatedAt = java.time.LocalDateTime.now();
    }
}

