package com.barbershop.appointment.domain.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private LocalTime beginTime;

    @Column(nullable = false)
    private LocalTime endTime;

    private String observations;

    @Column(nullable = false)
    private double fee;

    @OneToOne
    private Status status;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Service service;

    @JoinColumn(nullable = false)
    @OneToOne
    private User user;

    public Appointment() {}

    public Appointment(Long id, Date date, LocalTime beginTime, LocalTime endTime, String observations, double fee, Status status, Service service, User user) {
        this.id = id;
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.observations = observations;
        this.fee = fee;
        this.status = status;
        this.service = service;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
