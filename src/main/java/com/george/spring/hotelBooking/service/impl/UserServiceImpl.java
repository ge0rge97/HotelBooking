package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.domain.User;
import com.george.spring.hotelBooking.repository.UserRepository;
import com.george.spring.hotelBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }
    @Override
    public User getById(Long id) {
        return null;
    }
    @Override
    public User getByUsername(String username) {
        return null;
    }
    @Override
    public void deleteById(Long id) {

    }
}
