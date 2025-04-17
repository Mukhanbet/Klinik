package com.example.Klinik.controller;

import com.example.Klinik.model.dto.auth.DoctorRegisterRequest;
import com.example.Klinik.model.dto.auth.LoginRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import com.example.Klinik.model.dto.doctor.DoctorResponse;
import com.example.Klinik.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/pages")
public class PageController {

    private final DoctorService doctorService;

    @GetMapping("/not-found")
    public String notFound(Model model) {
        return "404";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/appointment")
    public String appointment(Model model) {
        return "appointment";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }

    @GetMapping("/feature")
    public String feature(Model model) {
        return "feature";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/service")
    public String service(Model model) {
        return "service";
    }

    @GetMapping("/our-doctor")
    public String team(Model model) {
        List<DoctorResponse> doctors = doctorService.all();
        model.addAttribute("doctors", doctors);
        return "team";
    }

    @GetMapping("/testimonial")
    public String testimonial(Model model) {
        return "testimonial";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @GetMapping("/doctor-register")
    public String doctorRegister(Model model) {
        model.addAttribute("doctorRequest", new DoctorRegisterRequest());
        return "doctor-register";
    }
}
