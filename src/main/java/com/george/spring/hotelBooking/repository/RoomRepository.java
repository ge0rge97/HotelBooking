package com.george.spring.hotelBooking.repository;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.domain.room.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByStatus(Status status);
}
