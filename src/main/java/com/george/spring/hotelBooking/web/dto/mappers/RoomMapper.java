package com.george.spring.hotelBooking.web.dto.mappers;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.web.dto.room.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDto toDto(Room room);
    Room toEntity(RoomDto roomDto);
}
