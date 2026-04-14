package com.hospital.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.hospital.hospital.entity.Doctor;
import com.hospital.hospital.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public Doctor add(@RequestBody Doctor d){
        return service.save(d);
    }

    @GetMapping
    public List<Doctor> all(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor one(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor d){
        return service.update(id, d);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Deleted";
    }
}
