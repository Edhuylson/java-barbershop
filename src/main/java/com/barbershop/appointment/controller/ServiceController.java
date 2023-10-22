package com.barbershop.appointment.controller;

import com.barbershop.appointment.domain.model.Service;
import com.barbershop.appointment.domain.model.Status;
import com.barbershop.appointment.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Service>> getAllServices() {
        var services = serviceService.findAll();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getService(@PathVariable Long id) {
        var service = serviceService.findById(id);
        return ResponseEntity.ok(service);
    }

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        var serviceCreated = serviceService.insert(service);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(serviceCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(serviceCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Long id, @RequestBody Service service) {
        serviceService.update(id, service);
        return ResponseEntity.ok(service);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
