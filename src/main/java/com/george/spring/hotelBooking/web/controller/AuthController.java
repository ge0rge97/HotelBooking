package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.service.AuthService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.auth.JwtRequest;
import com.george.spring.hotelBooking.web.dto.auth.JwtResponse;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "AUTH API")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    @Operation(summary = "Register new user.")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }
    @PostMapping("/login")
    @Operation(summary = "Login new user.")
    public JwtResponse login(@RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }
    @PostMapping("/refresh")
    @Operation(summary = "Refresh user tokens.")
    public JwtResponse refreshToken(@RequestBody String refreshToken) { return authService.refresh(refreshToken); }
}
