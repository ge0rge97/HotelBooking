package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.User;
import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.mappers.RoomMapper;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RoomService roomService;
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
