package com.hotel.management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;


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
}

