package com.hospital.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospital.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {}