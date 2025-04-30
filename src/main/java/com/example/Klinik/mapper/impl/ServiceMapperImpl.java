package com.example.Klinik.mapper.impl;

import com.example.Klinik.mapper.ServiceMapper;
import com.example.Klinik.model.domain.Image;
import com.example.Klinik.model.domain.Service;
import com.example.Klinik.model.dto.service.ServiceRequest;
import com.example.Klinik.model.dto.service.ServiceResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service toService(ServiceRequest request, Image icon, Image mainImage) {
        Service service = new Service();
        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setIcon(icon);
        service.setMainImage(mainImage);

        return service;
    }

    @Override
    public ServiceResponse toResponse(Service service) {
        ServiceResponse response = new ServiceResponse();
        response.setId(service.getId());
        response.setName(service.getName());
        response.setDescription(service.getDescription());
        if (service.getIcon() != null) {
            response.setIconUrl(service.getIcon().getPath());
        }
        if (service.getMainImage() != null) {
            response.setMainImageUrl(service.getMainImage().getPath());
        }

        return response;
    }

    @Override
    public List<ServiceResponse> toResponseList(List<Service> services) {
        List<ServiceResponse> responseList = new ArrayList<>();
        for (Service service : services) {
            responseList.add(toResponse(service));
        }
        return responseList;
    }
}
