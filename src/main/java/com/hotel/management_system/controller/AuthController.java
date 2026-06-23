package com.hotel.management_system.controller;

import com.hotel.management_system.model.Role;
import com.hotel.management_system.model.User;
import com.hotel.management_system.repository.RoleRepository;
import com.hotel.management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ENDPOINT REGISTRASI ADMIN BARU
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody User signUpRequest) {
        // 1. Cek apakah username sudah terpakai
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username sudah terpakai, bro!");
        }

        // 2. Cek apakah email sudah terpakai
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email sudah terdaftar!");
        }

        // 3. Bikin akun user baru & Enkripsi Password pake BCrypt
        User user = new User(
            signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            passwordEncoder.encode(signUpRequest.getPassword()) // Password otomatis di-hash!
        );

        // 4. Set default Role ke ROLE_ADMIN
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));
        user.setRoles(Collections.singleton(adminRole));

        // 5. Simpan ke PostgreSQL
        userRepository.save(user);

        return ResponseEntity.ok("Admin berhasil didaftarkan, bro! Password aman terenkripsi.");
    }
}