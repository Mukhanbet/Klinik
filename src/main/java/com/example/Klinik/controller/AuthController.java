package com.example.Klinik.controller;

import com.example.Klinik.model.dto.auth.AuthResponse;
import com.example.Klinik.model.dto.auth.DoctorRegisterRequest;
import com.example.Klinik.model.dto.auth.LoginRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import com.example.Klinik.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, HttpServletResponse response) {
        cookieOperation(authService.login(request), response);
        return "redirect:/api/pages/home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request, HttpServletResponse response) {
        cookieOperation(authService.register(request), response);
        return "redirect:/api/pages/home";
    }

    @PostMapping("/doctor/register")
    public String registerDoctor(
            @ModelAttribute DoctorRegisterRequest request,
            @RequestParam MultipartFile image
    ) {
        authService.register(request, image);
        return "redirect:/api/pages/home";
    }

    private void cookieOperation(AuthResponse authResponse, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("access_token", authResponse.getToken());

        tokenCookie.setMaxAge(24 * 60 * 60);
        tokenCookie.setPath("/");

        response.addCookie(tokenCookie);
    }
}
