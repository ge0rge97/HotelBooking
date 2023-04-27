package com.george.spring.hotelBooking.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "User Dto.")
public class UserDto {
    @Schema(description = "User Id", example = "1")
    private Long id;
    @Schema(description = "Username", example = "test1@test.com")
    @NotNull(message = "Username must be not null.")
    @Length(max = 255, message = "Username must be smaller than 255 symbols.")
    private String username;
    @Schema(description = "Password", example = "12345")
    @NotNull(message = "Password must be not null.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Schema(description = "Password Confirmation", example = "12345")
    @NotNull(message = "Confirmation must be not null.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;
}


