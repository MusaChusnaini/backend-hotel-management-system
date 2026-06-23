package com.hotel.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.management_system.model.Guest;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByEmail(String email);

}
