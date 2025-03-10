package com.example.Klinik.controller;

import com.example.Klinik.model.dto.appointment.AppointmentRequest;
import com.example.Klinik.model.dto.appointment.AppointmentResponse;
import com.example.Klinik.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/{doctorId}")
    public AppointmentResponse makeAppointment(
            @RequestBody AppointmentRequest request,
            @RequestHeader("Authorization") String token,
            @PathVariable Long doctorId
    ) {
        return appointmentService.makeAppointment(request, token, doctorId);
    }

    @GetMapping("/next")
    public AppointmentResponse getNextAppointment(@RequestHeader("Authorization") String token) {
        return appointmentService.getNextAppointment(token);
    }

    @GetMapping
    public List<AppointmentResponse> all(@RequestHeader("Authorization") String token) {
        return appointmentService.all(token);
    }
}
