package com.example.Klinik.service.impl;

import com.example.Klinik.model.domain.About;
import com.example.Klinik.repository.AboutRepository;
import com.example.Klinik.service.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;

    @Override
    public About createAbout(About about) {
        return aboutRepository.save(about);
    }

    @Override
    public List<About> all() {
        return aboutRepository.findAll();
    }
}
