package com.barbershop.appointment.service.impl;

import com.barbershop.appointment.domain.model.Service;
import com.barbershop.appointment.domain.model.Status;
import com.barbershop.appointment.domain.repository.ServiceRepository;
import com.barbershop.appointment.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        if(service.isPresent()) {
            return service.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Service insert(Service service) {
        serviceRepository.save(service);
        return service;
    }

    @Override
    public void update(Long id, Service service) {
        Optional<Service> existingService = serviceRepository.findById(id);
        if(existingService.isPresent()) {
            Service serviceToUpdate = existingService.get();

            serviceToUpdate.setName(service.getName());

            serviceRepository.save(serviceToUpdate);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }

}
