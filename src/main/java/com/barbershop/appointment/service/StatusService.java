package com.barbershop.appointment.service;

import com.barbershop.appointment.domain.model.Status;

public interface StatusService {

    Iterable<Status> findAll();
    Status findById(Long id);
    Status insert(Status status);
    void update(Long id, Status status);
    void delete(Long id);

}
