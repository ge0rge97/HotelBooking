package com.george.spring.hotelBooking.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {
    private Long id;
    @NotNull(message = "Username must be not null.")
    @Length(max = 255, message = "Username must be smaller than 255 symdols.")
    private String username;
    @NotNull(message = "Password must be not null.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotNull(message = "Confirmation must be not null.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;
}


