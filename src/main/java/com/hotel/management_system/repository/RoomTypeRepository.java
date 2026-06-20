package com.hotel.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management_system.model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
