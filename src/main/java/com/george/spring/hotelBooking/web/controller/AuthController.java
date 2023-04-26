package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.service.AuthService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.auth.JwtRequest;
import com.george.spring.hotelBooking.web.dto.auth.JwtResponse;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }
    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }
    @PostMapping("/refresh")
    public JwtResponse refreshToken(@RequestBody String refreshToken) { return authService.refresh(refreshToken); }
}
