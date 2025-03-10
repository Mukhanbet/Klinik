package com.example.Klinik.model.dto.appointment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponse {

    private Long id;

    private String doctor;

    private LocalDateTime date;

    private String description;

    private String status;

}
