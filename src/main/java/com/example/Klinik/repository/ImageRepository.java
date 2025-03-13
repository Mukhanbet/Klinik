package com.example.Klinik.repository;

import com.example.Klinik.model.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Transactional
    void deleteByFileName(String filename);

}
