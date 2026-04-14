package com.hospital.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.hospital.hospital.entity.Patient;
import com.hospital.hospital.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient add(@Valid @RequestBody Patient p){
        return service.save(p);
    }

    @GetMapping
    public List<Patient> all(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient one(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient p){
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Deleted";
    }
}