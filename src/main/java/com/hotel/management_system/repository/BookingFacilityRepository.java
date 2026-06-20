package com.hotel.management_system.repository;

import com.hotel.management_system.model.BookingFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFacilityRepository extends JpaRepository<BookingFacility, Long> {
}