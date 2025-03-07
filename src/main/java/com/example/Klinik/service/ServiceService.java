package com.example.Klinik.service;

import com.example.Klinik.model.dto.service.ServiceRequest;
import com.example.Klinik.model.dto.service.ServiceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ServiceService {

    ServiceResponse create(ServiceRequest serviceRequest, MultipartFile icon);

    void delete(Long id);

    ServiceResponse get(Long id);

    List<ServiceResponse> all();

}
