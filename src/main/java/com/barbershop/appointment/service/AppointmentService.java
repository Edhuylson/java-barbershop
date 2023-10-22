package com.barbershop.appointment.service;

import com.barbershop.appointment.domain.model.Appointment;

public interface AppointmentService {

    Iterable<Appointment> findAll();
    Appointment findById(Long id);
    Appointment insert(Appointment appointment);
    void update(Long id, Appointment appointment);
    void delete(Long id);

}
