package com.example.Klinik.service.impl;

import com.example.Klinik.mapper.DoctorMapper;
import com.example.Klinik.model.dto.doctor.AmountResponse;
import com.example.Klinik.model.dto.doctor.DoctorResponse;
import com.example.Klinik.model.enums.Role;
import com.example.Klinik.repository.DoctorRepository;
import com.example.Klinik.repository.UserRepository;
import com.example.Klinik.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> all() {
        return doctorMapper.toResponses(doctorRepository.findAll());
    }

    @Override
    public AmountResponse getAmount() {
        AmountResponse amountResponse = new AmountResponse();
        amountResponse.setDoctors(userRepository.countUsersByRole(Role.DOCTOR));
        amountResponse.setPatients(userRepository.countUsersByRole(Role.PATIENT));

        return amountResponse;
    }
}
