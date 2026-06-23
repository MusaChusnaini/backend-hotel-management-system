package com.hotel.management_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

import com.hotel.management_system.dto.BookingRequestDTO;
import com.hotel.management_system.model.Booking;
import com.hotel.management_system.model.BookingFacility;
import com.hotel.management_system.model.Facility;
import com.hotel.management_system.model.Guest;
import com.hotel.management_system.model.Payment;
import com.hotel.management_system.model.Room;
import com.hotel.management_system.repository.BookingFacilityRepository;
import com.hotel.management_system.repository.BookingRepository;
import com.hotel.management_system.repository.FacilityRepository;
import com.hotel.management_system.repository.GuestRepository;
import com.hotel.management_system.repository.PaymentRepository;
import com.hotel.management_system.repository.RoomRepository;

@Service
public class BookingService {

    private final GuestRepository guestRepo;
    private final RoomRepository roomRepo;
    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final BookingFacilityRepository bookingFacilityRepo;
    private final PaymentRepository paymentRepo;

    public BookingService(GuestRepository guestRepo, RoomRepository roomRepo, 
                          BookingRepository bookingRepo, FacilityRepository facilityRepo, 
                          BookingFacilityRepository bookingFacilityRepo, PaymentRepository paymentRepo) {
        this.guestRepo = guestRepo;
        this.roomRepo = roomRepo;
        this.bookingRepo = bookingRepo;
        this.facilityRepo = facilityRepo;
        this.bookingFacilityRepo = bookingFacilityRepo;
        this.paymentRepo = paymentRepo;
    }

    @Transactional 
    public void processCompleteBooking(BookingRequestDTO req) {

        // Tahap 1: Simpan ke tabel guests
        // Tahap 1: Simpan ke tabel guests
        Guest guest = guestRepo.findByEmail(req.email) // <-- Pakai 'guestRepo' dan 'req'
                    .orElseGet(() -> {
                        // 2. Kalau TIDAK KETEMU, buat objek baru
                        Guest newGuest = new Guest();
                        newGuest.setEmail(req.email);
                        newGuest.setFullName(req.fullName);
                        newGuest.setNikOrPassport(req.nikOrPassport);
                        newGuest.setPhoneNumber(req.phoneNumber);
                        return guestRepo.save(newGuest); // <-- Pakai 'guestRepo'
                    });

        // Tahap 2: Update status di tabel rooms
        Room room = roomRepo.findById(req.roomId)
            .orElseThrow(() -> new RuntimeException("Kamar tidak ditemukan"));
        if (room.getStatus().equals("BOOKED")) {
            throw new RuntimeException("Kamar sudah dipesan orang lain!");
        }
        room.setStatus("BOOKED");
        roomRepo.save(room);

        // Tahap 3: Simpan ke tabel bookings
        Booking booking = new Booking();
        booking.setGuest(guest); 
        booking.setRoom(room);   
        booking.setCheckInDate(req.checkInDate);
        booking.setCheckOutDate(req.checkOutDate);
        booking.setTotalAmount(req.totalAmount);
        booking.setStatus("CHECK_IN");
        bookingRepo.save(booking);

        // Tahap 4: Simpan ke tabel booking_facilities
        if (req.facilities != null && !req.facilities.isEmpty()) {
            for (BookingRequestDTO.FacilityRequest facReq : req.facilities) {
                Facility facility = facilityRepo.findById(facReq.facilityId)
                    .orElseThrow(() -> new RuntimeException("Fasilitas tidak valid"));
                
                BookingFacility bf = new BookingFacility();
                bf.setBooking(booking);     
                bf.setFacility(facility);   
                bf.setQuantity(facReq.quantity);
                bookingFacilityRepo.save(bf);
            }
        }

        // Tahap 5: Simpan ke tabel payments
        Payment payment = new Payment();
        payment.setBooking(booking); 
        payment.setPaymentMethod(req.paymentMethod);
        payment.setAmountPaid(req.totalAmount);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepo.save(payment);
    }
}