package com.example.Klinik.mapper;

import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.dto.doctor.DoctorResponse;

import java.util.List;

public interface DoctorMapper {
    DoctorResponse toResponse(Doctor doctor);
    List<DoctorResponse> toResponses(List<Doctor> doctors);
}
