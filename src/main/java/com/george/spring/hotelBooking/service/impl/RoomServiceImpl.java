package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.generator.RoomGenerator;
import com.george.spring.hotelBooking.repository.RoomRepository;
import com.george.spring.hotelBooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

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
        return null;
    }
    @Override
    public List<Room> getAllByUserId(Long id) {
        return null;
    }
    @Override
    public List<Room> getAllFreeRoom() {
        return roomRepository.findAll();
    }
    @Override
    public Room bookRoom(Room room, Long userId) {
        return null;
    }
}
