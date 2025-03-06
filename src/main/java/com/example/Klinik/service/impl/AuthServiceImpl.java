package com.example.Klinik.service.impl;

import com.example.Klinik.config.JwtService;
import com.example.Klinik.exception.CustomException;
import com.example.Klinik.mapper.AuthMapper;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.auth.AuthResponse;
import com.example.Klinik.model.dto.auth.LoginRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import com.example.Klinik.repository.UserRepository;
import com.example.Klinik.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        AuthResponse response = new AuthResponse();
        response.setToken(
                jwtService.generateToken(
                        userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND))
                )
        );
        return response;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException("User with this email is already exists", HttpStatus.CONFLICT);
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userRepository.save(authMapper.toUser(request));

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(
                jwtService.generateToken(user)
        );
        return authResponse;
    }
}
