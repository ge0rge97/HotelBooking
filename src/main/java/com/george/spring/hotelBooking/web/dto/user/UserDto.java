package com.george.spring.hotelBooking.web.dto.user;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirmation;
}


