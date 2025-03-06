package com.example.Klinik.mapper;

import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.dto.auth.RegisterRequest;

public interface AuthMapper {
    User toUser(RegisterRequest request);
}
