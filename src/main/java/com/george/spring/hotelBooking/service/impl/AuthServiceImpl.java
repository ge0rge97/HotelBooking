package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.service.AuthService;
import com.george.spring.hotelBooking.web.dto.auth.JwtRequest;
import com.george.spring.hotelBooking.web.dto.auth.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest request) {
        return null;
    }
}
