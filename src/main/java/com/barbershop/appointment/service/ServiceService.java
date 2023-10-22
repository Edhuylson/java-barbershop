package com.barbershop.appointment.service;

import com.barbershop.appointment.domain.model.Service;

public interface ServiceService {

    Iterable<Service> findAll();
    Service findById(Long id);
    Service insert(Service service);
    void update(Long id, Service service);
    void delete(Long id);

}
