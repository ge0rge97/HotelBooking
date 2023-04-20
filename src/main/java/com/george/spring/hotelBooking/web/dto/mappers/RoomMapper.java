package com.george.spring.hotelBooking.web.dto.mappers;

import com.george.spring.hotelBooking.domain.room.Room;
import com.george.spring.hotelBooking.web.dto.room.RoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(target = "id", source = "room.id")
    RoomDto toDto(Room room);
    List<RoomDto> toDto(List<Room> tasks);
    Room toEntity(RoomDto roomDto);
}
