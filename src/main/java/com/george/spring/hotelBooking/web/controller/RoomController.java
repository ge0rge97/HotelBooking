package com.george.spring.hotelBooking.web.controller;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.service.RoomService;
import com.george.spring.hotelBooking.service.UserService;
import com.george.spring.hotelBooking.web.dto.mappers.RoomMapper;
import com.george.spring.hotelBooking.web.dto.mappers.UserMapper;
import com.george.spring.hotelBooking.web.dto.room.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final UserService userService;
    private final RoomService roomService;
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    @GetMapping("")
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return roomMapper.toDto(rooms);
    }
    @GetMapping("/free")
    public List<RoomDto> getAllFreeRooms() {
        List<RoomDto> rooms = roomMapper.toDto(roomService.getAllFreeRooms());
        return rooms;
    }
    @GetMapping("/{id}")
    public RoomDto getRoomById(@PathVariable Long id) {
        Room room = roomService.getById(id);
        return roomMapper.toDto(room);
    }
    @PutMapping("")
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        Room updatedRoom = roomService.updateRoom(room);
        return roomMapper.toDto(updatedRoom);
    }
    @PostMapping("/generate")
    public void generateFakeRooms() {
        roomService.generateRoom(10);
    }
    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) { roomService.deleteById(id); }
}
