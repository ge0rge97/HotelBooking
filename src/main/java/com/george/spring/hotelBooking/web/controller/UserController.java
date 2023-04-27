package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.mappers.RoomMapper;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.room.RoomDto;
import com.george.spring.hotelBooking.web.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "USER API")
public class UserController {
    private final UserService userService;
    private final RoomService roomService;
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Get user by userId.")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }
    @GetMapping("/{id}/rooms")
    @Operation(summary = "Get all users book rooms by userId.")
    public List<RoomDto> getAllRoomsByUserId(@PathVariable Long id) {
        List<Room> rooms = roomService.getAllByUserId(id);
        return roomMapper.toDto(rooms);
    }
    @PostMapping("/{id}/rooms/book/{roomId}")
    @Operation(summary = "Book room by user with userId and roomId.")
    public RoomDto bookRoom(@PathVariable Long id, @PathVariable Long roomId) {
        Room room = roomService.bookRoom(id, roomId);
        return roomMapper.toDto(room);
    }
    @PostMapping("/{id}/rooms/book/{roomId}/cancel")
    @Operation(summary = "Cancel book room by user with userId and roomId.")
    public RoomDto cancelBookRoom(@PathVariable Long id, @PathVariable Long roomId) {
        Room room = roomService.cancelBookRoom(id, roomId);
        return roomMapper.toDto(room);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by userId.")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
