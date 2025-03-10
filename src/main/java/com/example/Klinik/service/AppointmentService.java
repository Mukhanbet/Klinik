package com.example.Klinik.service;

import com.example.Klinik.model.dto.appointment.AppointmentRequest;
import com.example.Klinik.model.dto.appointment.AppointmentResponse;

import java.util.List;

public interface AppointmentService {

    AppointmentResponse makeAppointment(AppointmentRequest request, String token, Long doctorId);

    AppointmentResponse getNextAppointment(String token);

    List<AppointmentResponse> all(String token);
}
