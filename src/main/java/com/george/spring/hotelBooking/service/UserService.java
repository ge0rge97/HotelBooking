package com.george.spring.hotelBooking.service;

import com.george.spring.hotelBooking.domain.user.User;

public interface UserService {
    User create(User user);
    User getById(Long id);
    User getByUsername(String username);
    void deleteById(Long id);
}
