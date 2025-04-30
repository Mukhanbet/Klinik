package com.example.Klinik.controller;

import com.example.Klinik.model.dto.service.ServiceRequest;
import com.example.Klinik.model.dto.service.ServiceResponse;
import com.example.Klinik.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/services")
public class ServiceController {
    private final ServiceService service;

    @PostMapping
    public ServiceResponse create(
            @RequestPart ServiceRequest serviceRequest,
            @RequestPart MultipartFile icon,
            @RequestPart MultipartFile mainImage
    ) {
        return service.create(serviceRequest, icon, mainImage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @GetMapping("/{id}")
    public ServiceResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<ServiceResponse> all() {
        return service.all();
    }
}
