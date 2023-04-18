package com.george.spring.hotelBooking.service;

import com.george.spring.hotelBooking.web.dto.auth.JwtRequest;
import com.george.spring.hotelBooking.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest request);
}
