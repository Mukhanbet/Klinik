package com.example.Klinik.model.dto.doctor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponse {

    private Long id;

    private String name;

    private String department;

    private String facebook;

    private String instagram;

    private String whatsapp;

    private String imageUrl;

}
