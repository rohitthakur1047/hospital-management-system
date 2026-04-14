package com.hospital.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.hospital.hospital.entity.*;
import com.hospital.hospital.repository.*;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    public Appointment save(Appointment a){

        Patient p = patientRepo.findById(a.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor d = doctorRepo.findById(a.getDoctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        a.setPatient(p);
        a.setDoctor(d);
        a.setStatus("BOOKED");

        return repo.save(a);
    }

    public List<Appointment> getAll(){
        return repo.findAll();
    }

    public Appointment getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment update(Long id, Appointment a){
        Appointment existing = getById(id);
        existing.setDate(a.getDate());
        existing.setStatus(a.getStatus());
        return repo.save(existing);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}