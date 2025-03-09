package com.example.Klinik.service.impl;

import com.example.Klinik.mapper.DoctorMapper;
import com.example.Klinik.model.dto.doctor.DoctorResponse;
import com.example.Klinik.repository.DoctorRepository;
import com.example.Klinik.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> all() {
        return doctorMapper.toResponses(doctorRepository.findAll());
    }
}
