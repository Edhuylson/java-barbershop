package com.barbershop.appointment.service;

import com.barbershop.appointment.domain.model.User;

public interface UserService {

    Iterable<User> findAll();
    User findById(Long id);
    User insert(User user);
    void update(Long id, User user);
    void delete(Long id);

}
