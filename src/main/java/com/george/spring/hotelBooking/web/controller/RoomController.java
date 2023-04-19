package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final UserService userService;
    private final RoomService roomService;
}
