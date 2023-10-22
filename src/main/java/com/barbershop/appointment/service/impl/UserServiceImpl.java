package com.barbershop.appointment.service.impl;

import com.barbershop.appointment.domain.model.User;
import com.barbershop.appointment.domain.repository.UserRepository;
import com.barbershop.appointment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public User insert(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            User userToUpdate = existingUser.get();

            userToUpdate.setFullName(user.getFullName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setPhoneNumber(user.getPhoneNumber());
            userToUpdate.setAppointments(user.getAppointments());

            userRepository.save(userToUpdate);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
