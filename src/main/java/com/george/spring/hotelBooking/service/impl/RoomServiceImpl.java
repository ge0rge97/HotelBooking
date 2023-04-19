package com.george.spring.hotelBooking.service.impl;

import com.george.spring.hotelBooking.domain.Room;
import com.george.spring.hotelBooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
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
        return null;
    }
    @Override
    public Room bookRoom(Room room, Long userId) {
        return null;
    }
}
