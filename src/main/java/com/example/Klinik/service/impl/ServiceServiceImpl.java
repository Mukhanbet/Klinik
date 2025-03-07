package com.example.Klinik.service.impl;

import com.example.Klinik.exception.CustomException;
import com.example.Klinik.mapper.ServiceMapper;
import com.example.Klinik.model.dto.service.ServiceRequest;
import com.example.Klinik.model.dto.service.ServiceResponse;
import com.example.Klinik.repository.ServiceRepository;
import com.example.Klinik.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    @Override
    public ServiceResponse create(ServiceRequest serviceRequest, MultipartFile icon) {
        if (serviceRepository.findByName(serviceRequest.getName()).isPresent()) {
            throw new CustomException("Service with this name is already exists", HttpStatus.CONFLICT);
        }

        return serviceMapper.toResponse(
                serviceRepository.save(
                        serviceMapper.toService(serviceRequest)
                )
        );

    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public ServiceResponse get(Long id) {
        return serviceMapper.toResponse(
                serviceRepository.findById(id).orElseThrow(() -> new CustomException("Service with this id does not exist", HttpStatus.NOT_FOUND))
        );
    }

    @Override
    public List<ServiceResponse> all() {
        return serviceMapper.toResponseList(serviceRepository.findAll());
    }
}
