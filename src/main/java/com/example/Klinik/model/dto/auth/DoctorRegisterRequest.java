package com.example.Klinik.model.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRegisterRequest extends RegisterRequest {

    private String department;

    private String facebook;

    private String instagram;

    private String whatsapp;

}
