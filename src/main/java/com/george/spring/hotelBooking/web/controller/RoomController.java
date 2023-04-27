package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.mappers.RoomMapper;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.room.RoomDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
@Tag(name = "Room Controller", description = "ROOM API")
public class RoomController {
    private final UserService userService;
    private final RoomService roomService;
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    @GetMapping("")
    @Operation(summary = "Get all hotel rooms.")
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return roomMapper.toDto(rooms);
    }
    @GetMapping("/free")
    @Operation(summary = "Get all available rooms.")
    public List<RoomDto> getAllFreeRooms() {
        List<RoomDto> rooms = roomMapper.toDto(roomService.getAllFreeRooms());
        return rooms;
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get room by roomId.")
    public RoomDto getRoomById(@PathVariable Long id) {
        Room room = roomService.getById(id);
        return roomMapper.toDto(room);
    }
    @PutMapping("")
    @Operation(summary = "Update room information.")
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        Room updatedRoom = roomService.updateRoom(room);
        return roomMapper.toDto(updatedRoom);
    }
    @PostMapping("/generate")
    @Operation(summary = "Generate fake room for testing.")
    public void generateFakeRooms() {
        roomService.generateRoom(10);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete room by roomId.")
    public void deleteRoomById(@PathVariable Long id) { roomService.deleteById(id); }
}
