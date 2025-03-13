package com.example.Klinik.service;

import com.example.Klinik.model.domain.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image save(MultipartFile image);
    void delete(String filename);
}
