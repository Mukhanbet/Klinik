package com.example.Klinik.service;

import com.example.Klinik.model.domain.About;

import java.util.List;

public interface AboutService {
    About createAbout(About about);
    List<About> all();
}
