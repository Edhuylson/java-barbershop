package com.barbershop.appointment.service.impl;

import com.barbershop.appointment.domain.model.Status;
import com.barbershop.appointment.domain.model.User;
import com.barbershop.appointment.domain.repository.StatusRepository;
import com.barbershop.appointment.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Iterable<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        if(status.isPresent()) {
            return status.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Status insert(Status status) {
        statusRepository.save(status);
        return status;
    }

    @Override
    public void update(Long id, Status status) {
        Optional<Status> existingStatus = statusRepository.findById(id);
        if(existingStatus.isPresent()) {
            Status statusToUpdate = existingStatus.get();

            statusToUpdate.setName(status.getName());

            statusRepository.save(statusToUpdate);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void delete(Long id) {
        statusRepository.deleteById(id);
    }

}
