package com.example.Klinik.mapper;

import com.example.Klinik.model.domain.Image;
import com.example.Klinik.model.domain.Service;
import com.example.Klinik.model.dto.service.ServiceRequest;
import com.example.Klinik.model.dto.service.ServiceResponse;

import java.util.List;

public interface ServiceMapper {

    Service toService(ServiceRequest request, Image icon);

    ServiceResponse toResponse(Service service);

    List<ServiceResponse> toResponseList(List<Service> services);
}
