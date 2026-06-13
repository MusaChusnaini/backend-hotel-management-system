package com.hotel.management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facility_name", nullable = false)
    private String facilityName;

    @Column(name = "price", nullable = false)
    private Double price;

    public Facility() {}

    public Facility(Long id, String facilityName, Double price) {
        this.id = id;
        this.facilityName = facilityName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public String getFacilityName() {
        return facilityName;
    }
    public Double getPrice() {
        return price;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
