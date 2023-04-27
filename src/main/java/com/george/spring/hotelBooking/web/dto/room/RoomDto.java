package com.george.spring.hotelBooking.web.dto.room;

import com.george.spring.hotelBooking.domain.room.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "Room Dto.")
public class RoomDto {
    @Schema(description = "Room id", example = "1")
    private Long id;
    @Schema(description = "Room name", example = "STANDARD")
    @NotNull(message = "Name must be not null.")
    @Length(max = 255,
            message = "Name must be smaller than 255 symbols.")
    private String name;
    @Schema(description = "Room description", example = "Comfortable room")
    @Length(max = 255,
            message = "Description must be smaller than 255 symbols.")
    private String description;
    @Schema(description = "Room price", example = "150.50")
    @NotNull(message = "Price must be not null.")
    private Double pricePerNight;
    @Schema(description = "Room status", example = "AVAILABLE_ROOM")
    private Status status;
}
