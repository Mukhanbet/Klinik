package com.example.Klinik.controller;

import com.example.Klinik.model.domain.About;
import com.example.Klinik.service.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/about")
public class AboutController {
    private final AboutService aboutService;

    @PostMapping("/create")
    public About create(@RequestBody About about) {
        return aboutService.createAbout(about);
    }

    @GetMapping("/all")
    public List<About> getAll() {
        return aboutService.all();
    }
}
