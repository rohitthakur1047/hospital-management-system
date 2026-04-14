package com.hospital.hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
