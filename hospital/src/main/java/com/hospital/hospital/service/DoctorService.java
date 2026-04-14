package com.hospital.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.hospital.hospital.entity.Doctor;
import com.hospital.hospital.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public Doctor save(Doctor d){
        return repo.save(d);
    }

    public List<Doctor> getAll(){
        return repo.findAll();
    }

    public Doctor getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor update(Long id, Doctor d){
        Doctor existing = getById(id);
        existing.setName(d.getName());
        existing.setSpecialization(d.getSpecialization());
        return repo.save(existing);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}