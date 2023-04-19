package com.george.spring.hotelBooking.service;

import com.george.spring.hotelBooking.domain.User;
import com.george.spring.hotelBooking.exception.ResourceNotFoundException;

public interface UserService {
    User create(User user);
    User getById(Long id);
    User getByUsername(String username);
    void deleteById(Long id);
}
