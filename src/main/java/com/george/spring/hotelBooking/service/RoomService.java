package com.george.spring.hotelBooking.service;

import com.george.spring.hotelBooking.domain.room.Room;

import java.util.List;

public interface RoomService {
    public void generateRoom(int roomCount);
    Room getById(Long id);
    List<Room> getAllByUserId(Long id);
    List<Room> getAllFreeRooms();
    Room bookRoom(Long userId, Long roomId);
    Room cancelBookRoom(Long userId, Long roomId);
    void deleteById(Long id);
}
