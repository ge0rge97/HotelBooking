package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.mappers.RoomMapper;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.room.RoomDto;
import com.george.spring.hotelBooking.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}/rooms")
    public List<RoomDto> getAllRoomsByUserId(@PathVariable Long id) {
        List<Room> rooms = roomService.getAllByUserId(id);
        return roomMapper.toDto(rooms);
    }
    @PostMapping("/{id}/rooms/book/{roomId}")
    public RoomDto bookRoom(@PathVariable Long id, @PathVariable Long roomId) {
        Room room = roomService.bookRoom(id, roomId);
        return roomMapper.toDto(room);
    }
    @PostMapping("/{id}/rooms/book/{roomId}/cancel")
    public RoomDto cancelBookRoom(@PathVariable Long id, @PathVariable Long roomId) {
        Room room = roomService.cancelBookRoom(id, roomId);
        return roomMapper.toDto(room);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
