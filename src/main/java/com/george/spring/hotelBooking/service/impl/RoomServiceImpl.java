package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.domain.room.Status;
import com.george.spring.hotelBooking.domain.user.User;
import com.george.spring.hotelBooking.exception.ResourceNotFoundException;
import com.george.spring.hotelBooking.generator.RoomGenerator;
import com.george.spring.hotelBooking.repository.RoomRepository;
import com.george.spring.hotelBooking.repository.UserRepository;
import com.george.spring.hotelBooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public void generateRoom(int roomCount) {
        roomRepository.deleteAll();
        for (int i = 0; i < roomCount; i++) {
            Room room = RoomGenerator.generateRoom();
            roomRepository.save(room);
        }
    }
    @Override
    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not Found"));
    }
    @Override
    public List<Room> getAllByUserId(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        return user.getBookedRoom();
    }
    @Override
    public List<Room> getAllRooms() { return roomRepository.findAll(); }
    @Override
    public List<Room> getAllFreeRooms() {
        return roomRepository.findByStatus(Status.AVAILABLE_ROOM);
    }
    @Override
    public Room bookRoom(Long userId, Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not Found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        room.setStatus(Status.BOOKED_ROOM);
        room.setUser(user);
        user.getBookedRoom().add(room);
        roomRepository.save(room);
        userRepository.save(user);
        return room;
    }
    @Override
    public Room cancelBookRoom(Long userId, Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not Found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        room.setStatus(Status.AVAILABLE_ROOM);
        room.setUser(null);
        user.getBookedRoom().remove(room);
        roomRepository.save(room);
        userRepository.save(user);
        return room;
    }
    @Override
    public void deleteById(Long id) { roomRepository.deleteById(id); }
}
