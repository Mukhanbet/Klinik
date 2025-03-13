package com.example.Klinik.service.impl;

import com.example.Klinik.config.JwtService;
import com.example.Klinik.exception.CustomException;
import com.example.Klinik.mapper.AppointmentMapper;
import com.example.Klinik.model.domain.Appointment;
import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.appointment.AppointmentRequest;
import com.example.Klinik.model.dto.appointment.AppointmentResponse;
import com.example.Klinik.model.enums.Role;
import com.example.Klinik.model.enums.Status;
import com.example.Klinik.repository.AppointmentRepository;
import com.example.Klinik.repository.DoctorRepository;
import com.example.Klinik.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentMapper appointmentMapper;
    private final JwtService jwtService;

    @Override
    public AppointmentResponse makeAppointment(AppointmentRequest request, String token, Long doctorId) {
        if (request.getStartTime().isBefore(LocalDateTime.now())) {
            throw new CustomException("Time is not correct", HttpStatus.BAD_REQUEST);
        }

        User patient = jwtService.getUserFromToken(token);
        if (patient.getRole().equals(Role.DOCTOR)) {
            throw new CustomException("You are not able to make appointment", HttpStatus.FORBIDDEN);
        }

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new CustomException("Doctor not found", HttpStatus.NOT_FOUND));

        for (Appointment appointment : appointmentRepository.findAllByDoctor(doctor)) {
            if (!(request.getStartTime().isAfter(appointment.getDate().plusMinutes(30)) && request.getStartTime().isBefore(appointment.getDate().minusMinutes(30)))) {
                throw new CustomException("Doctor in this time is busy", HttpStatus.BAD_REQUEST);
            }
        }
        return appointmentMapper.toResponse(appointmentRepository.save(appointmentMapper.toAppointment(request, patient, doctor)));
    }

    @Override
    public AppointmentResponse getNextAppointment(String token) {
        User patient = jwtService.getUserFromToken(token);

        return appointmentMapper.toResponse(appointmentRepository.findFirstByPatientAndStatus(patient, Status.PROGRESS).orElseThrow(() -> new CustomException("Appointment not found", HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<AppointmentResponse> all(String token) {
        User patient = jwtService.getUserFromToken(token);

        return appointmentMapper.toResponseList(appointmentRepository.findAllByPatient(patient));
    }

    @Scheduled(cron = "0 */5 * * * *")
    private void updateStatuses() {
        for (Appointment appointment : appointmentRepository.findAll()) {
            if (appointment.getDate().isBefore(LocalDateTime.now())) {
                appointment.setStatus(Status.DONE);
            }
        }
    }
}
