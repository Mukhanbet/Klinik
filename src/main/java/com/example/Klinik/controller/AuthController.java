package com.example.Klinik.controller;

import com.example.Klinik.model.dto.auth.AuthResponse;
import com.example.Klinik.model.dto.auth.DoctorRegisterRequest;
import com.example.Klinik.model.dto.auth.LoginRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import com.example.Klinik.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/doctor/register")
    public AuthResponse registerDoctor(
            @RequestPart DoctorRegisterRequest request,
            @RequestPart MultipartFile image) {
        return authService.register(request, image);
    }
}
