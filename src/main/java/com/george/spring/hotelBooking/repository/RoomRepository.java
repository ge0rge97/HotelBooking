package com.george.spring.hotelBooking.repository;

import com.george.spring.hotelBooking.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
