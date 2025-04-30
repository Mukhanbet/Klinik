package com.example.Klinik.controller;

import com.example.Klinik.model.dto.doctor.AmountResponse;
import com.example.Klinik.model.dto.doctor.DoctorResponse;
import com.example.Klinik.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorResponse> all() {
        return doctorService.all();
    }

    @GetMapping("/amount")
    public AmountResponse getAmount() {
        return doctorService.getAmount();
    }
}
