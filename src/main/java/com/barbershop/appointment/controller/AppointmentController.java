package com.barbershop.appointment.controller;

import com.barbershop.appointment.domain.model.Appointment;
import com.barbershop.appointment.domain.model.Status;
import com.barbershop.appointment.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Appointment>> getAllAppointments() {
        var appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        var appointment = appointmentService.findById(id);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        var appointmentCreated = appointmentService.insert(appointment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(appointmentCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(appointmentCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        appointmentService.update(id, appointment);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
