package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.exception.ResourceNotFoundException;
import com.george.spring.hotelBooking.repository.UserRepository;
import com.george.spring.hotelBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
    }
    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
    }
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
