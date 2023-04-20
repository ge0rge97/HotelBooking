package com.george.spring.hotelBooking.web.dto.room;

import com.george.spring.hotelBooking.domain.room.Status;
import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String name;
    private String description;
    private Double pricePerNight;
    private Status status;
}
