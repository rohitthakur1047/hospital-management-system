package com.hospital.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
