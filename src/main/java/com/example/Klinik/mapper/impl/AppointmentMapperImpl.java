package com.example.Klinik.mapper.impl;

import com.example.Klinik.mapper.AppointmentMapper;
import com.example.Klinik.model.domain.Appointment;
import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.appointment.AppointmentRequest;
import com.example.Klinik.model.dto.appointment.AppointmentResponse;
import com.example.Klinik.model.enums.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public Appointment toAppointment(AppointmentRequest request, User patient, Doctor doctor) {
        Appointment appointment = new Appointment();
        appointment.setDate(request.getStartTime());
        appointment.setDescription(request.getDescription());
        appointment.setStatus(Status.PROGRESS);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointment;
    }

    @Override
    public AppointmentResponse toResponse(Appointment appointment) {
        AppointmentResponse response = new AppointmentResponse();
        response.setId(appointment.getId());
        response.setDoctor(appointment.getDoctor().getUserDetails().getName());
        response.setDate(appointment.getDate());
        response.setDescription(appointment.getDescription());
        response.setStatus(String.valueOf(appointment.getStatus()));

        return response;
    }

    @Override
    public List<AppointmentResponse> toResponseList(List<Appointment> appointments) {
        List<AppointmentResponse> responseList = new ArrayList<>();
        for (Appointment appointment : appointments) {
            responseList.add(toResponse(appointment));
        }

        return responseList;
    }
}
