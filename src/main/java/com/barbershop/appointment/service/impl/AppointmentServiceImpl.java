package com.barbershop.appointment.service.impl;

import com.barbershop.appointment.domain.model.Appointment;
import com.barbershop.appointment.domain.repository.AppointmentRepository;
import com.barbershop.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()) {
            return appointment.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Appointment insert(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public void update(Long id, Appointment appointment) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if(existingAppointment.isPresent()) {
            Appointment appointmentToUpdate = existingAppointment.get();

            appointmentToUpdate.setDate(appointment.getDate());
            appointmentToUpdate.setBeginTime(appointment.getBeginTime());
            appointmentToUpdate.setEndTime(appointment.getEndTime());
            appointmentToUpdate.setObservations(appointment.getObservations());
            appointmentToUpdate.setFee(appointment.getFee());
            appointmentToUpdate.setStatus(appointment.getStatus());
            appointmentToUpdate.setService(appointment.getService());
            appointmentToUpdate.setUser(appointment.getUser());

            appointmentRepository.save(appointmentToUpdate);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

}
