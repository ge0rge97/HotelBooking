package com.george.spring.hotelBooking.web.security;

import com.george.spring.hotelBooking.domain.user.User;

public class JwtEntityFactory {
    public static JwtEntity create(User user) {
        return new JwtEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
