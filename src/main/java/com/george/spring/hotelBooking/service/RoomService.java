package com.george.spring.hotelBooking.service;

import com.george.spring.hotelBooking.domain.Room;

import java.util.List;

public interface RoomService {
    Room getById(Long id);
    List<Room> getAllByUserId(Long id);
    List<Room> getAllFreeRoom();
    Room bookRoom(Room room, Long userId);
}
