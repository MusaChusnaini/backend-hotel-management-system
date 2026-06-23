package com.hotel.management_system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BookingRequestDTO {
    // 1. Data Tamu
    public String fullName;
    public String nikOrPassport;
    public String phoneNumber;
    public String email;

    // 2. Data Booking Inti
    public LocalDate checkInDate;
    public LocalDate checkOutDate;
    public Long roomId;
    public BigDecimal totalAmount;

    // 3. Data Fasilitas Tambahan (Format Array)
    public List<FacilityRequest> facilities;

    // 4. Data Pembayaran
    public String paymentMethod;

    // Sub-class khusus untuk array fasilitas
    public static class FacilityRequest {
        public Long facilityId;
        public Integer quantity;
    }

    
}