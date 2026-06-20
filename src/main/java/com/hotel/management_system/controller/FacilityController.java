package com.hotel.management_system.controller;
import com.hotel.management_system.model.Facility;
import com.hotel.management_system.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
    
    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return facilityRepository.save(facility);
    }
}
