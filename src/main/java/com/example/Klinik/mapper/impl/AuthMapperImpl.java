package com.example.Klinik.mapper.impl;

import com.example.Klinik.mapper.AuthMapper;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.auth.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public User toUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }
}
