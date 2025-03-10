package com.example.Klinik.model.dto.appointment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRequest {

    private String description;

    private LocalDateTime startTime;

}
