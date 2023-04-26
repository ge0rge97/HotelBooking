package com.george.spring.hotelBooking.web.dto.room;

import com.george.spring.hotelBooking.domain.room.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RoomDto {
    private Long id;
    @NotNull(message = "Name must be not null.")
    @Length(max = 255,
            message = "Name must be smaller than 255 symbols.")
    private String name;
    @Length(max = 255,
            message = "Description must be smaller than 255 symbols.")
    private String description;
    @NotNull(message = "Price must be not null.")
    private Double pricePerNight;
    private Status status;
}
