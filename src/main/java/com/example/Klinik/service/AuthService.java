package com.example.Klinik.service;

import com.example.Klinik.model.dto.auth.AuthResponse;
import com.example.Klinik.model.dto.auth.DoctorRegisterRequest;
import com.example.Klinik.model.dto.auth.LoginRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);

    AuthResponse register(DoctorRegisterRequest request, MultipartFile image);
}
