package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.service.AuthService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.auth.JwtRequest;
import com.george.spring.hotelBooking.web.dto.auth.JwtResponse;
import com.george.spring.hotelBooking.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userService.getByUsername(loginRequest.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUsername()));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));
        return jwtResponse;
    }
    @Override
    public JwtResponse refresh(String refreshToken) { return jwtTokenProvider.refreshUserTokens(refreshToken); }
}
