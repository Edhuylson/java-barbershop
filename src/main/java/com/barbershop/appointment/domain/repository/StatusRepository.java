package com.barbershop.appointment.domain.repository;

import com.barbershop.appointment.domain.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
