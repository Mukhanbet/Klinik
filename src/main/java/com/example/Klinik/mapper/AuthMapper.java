package com.example.Klinik.mapper;

import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.auth.DoctorRegisterRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;

public interface AuthMapper {
    User toUser(RegisterRequest request);
    Doctor toDoctor(DoctorRegisterRequest request, User user);
}
