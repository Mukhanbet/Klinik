package com.example.Klinik.mapper.impl;

import com.example.Klinik.mapper.DoctorMapper;
import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.dto.doctor.DoctorResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapperImpl implements DoctorMapper {
    @Override
    public DoctorResponse toResponse(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getUserDetails().getName());
        response.setDepartment(doctor.getDepartment());
        response.setFacebook(doctor.getFacebook());
        response.setInstagram(doctor.getInstagram());
        response.setWhatsapp(doctor.getWhatsapp());
        return response;
    }

    @Override
    public List<DoctorResponse> toResponses(List<Doctor> doctors) {
        List<DoctorResponse> responses = new ArrayList<>();
        for (Doctor doctor : doctors) {
            responses.add(toResponse(doctor));
        }
        return responses;
    }
}
