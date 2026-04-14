package com.hospital.hospital.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.hospital.hospital.entity.Patient;
import com.hospital.hospital.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public Patient save(Patient p){
        return repo.save(p);
    }

    public List<Patient> getAll(){
        return repo.findAll();
    }

    public Patient getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient update(Long id, Patient p){
        Patient existing = getById(id);
        existing.setName(p.getName());
        existing.setAge(p.getAge());
        existing.setGender(p.getGender());
        existing.setPhone(p.getPhone());
        return repo.save(existing);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}