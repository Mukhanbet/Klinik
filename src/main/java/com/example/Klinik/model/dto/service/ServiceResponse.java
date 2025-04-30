package com.example.Klinik.model.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {

    private Long id;

    private String name;

    private String description;

    private String iconUrl;

    private String mainImageUrl;

}
