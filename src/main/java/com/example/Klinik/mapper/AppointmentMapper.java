package com.example.Klinik.mapper;

import com.example.Klinik.model.domain.Appointment;
import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.appointment.AppointmentRequest;
import com.example.Klinik.model.dto.appointment.AppointmentResponse;

import java.util.List;

public interface AppointmentMapper {

    Appointment toAppointment(AppointmentRequest request, User patient, Doctor doctor);

    AppointmentResponse toResponse(Appointment appointment);

    List<AppointmentResponse> toResponseList(List<Appointment> appointments);

}
