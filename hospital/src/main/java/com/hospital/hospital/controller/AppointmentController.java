package com.hospital.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.hospital.hospital.entity.Appointment;
import com.hospital.hospital.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment book(@RequestBody Appointment a){
        return service.save(a);
    }

    @GetMapping
    public List<Appointment> all(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String cancel(@PathVariable Long id){
        service.delete(id);
        return "Cancelled";
    }
}