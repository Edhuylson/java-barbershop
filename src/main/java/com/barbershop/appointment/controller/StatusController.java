package com.barbershop.appointment.controller;

import com.barbershop.appointment.domain.model.Status;
import com.barbershop.appointment.service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Status>> getAllStatuses() {
        var statuses = statusService.findAll();
        return ResponseEntity.ok(statuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatus(@PathVariable Long id) {
        var status = statusService.findById(id);
        return ResponseEntity.ok(status);
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        var statusCreated = statusService.insert(status);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(statusCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(statusCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        statusService.update(id, status);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.delete(id);
        return ResponseEntity.ok().build();
    }

}
