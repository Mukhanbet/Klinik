package com.example.Klinik.mapper.impl;

import com.example.Klinik.mapper.AuthMapper;
import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.domain.Image;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.auth.DoctorRegisterRequest;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import com.example.Klinik.model.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public User toUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setPassword(request.getPassword());
        user.setRole(Role.PATIENT);
        return user;
    }

    @Override
    public Doctor toDoctor(DoctorRegisterRequest request, User user, Image image) {
        Doctor doctor = new Doctor();
        doctor.setDepartment(request.getDepartment());
        doctor.setFacebook(request.getFacebook());
        doctor.setInstagram(request.getInstagram());
        doctor.setWhatsapp(request.getWhatsapp());
        user.setRole(Role.DOCTOR);
        doctor.setUserDetails(user);
        doctor.setImage(image);
        return doctor;
    }
}
