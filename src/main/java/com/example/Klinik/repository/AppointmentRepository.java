package com.example.Klinik.repository;

import com.example.Klinik.model.domain.Appointment;
import com.example.Klinik.model.domain.Doctor;
import com.example.Klinik.model.domain.User;
import com.example.Klinik.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDoctor(Doctor doctor);

    @Query(
            "SELECT a FROM Appointment a " +
                    "WHERE a.patient = :patient " +
                    "AND a.status = :status " +
                    "ORDER BY a.date ASC"
    )
    Optional<Appointment> findFirstByPatientAndStatus(@Param("patient") User patient, @Param("status") Status status);

    List<Appointment> findAllByPatient(User patient);
}
