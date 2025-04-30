package com.example.Klinik.repository;

import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Long countUsersByRole(Role role);
}
