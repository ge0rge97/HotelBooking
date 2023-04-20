package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final UserService userService;
    private final RoomService roomService;

    @PostMapping("/generate")
    public void generateFakeRooms() {
        roomService.generateRoom(10);
    }
    @GetMapping()
    public List<Room> getAllRooms() {
        return roomService.getAllFreeRoom();
    }
}
