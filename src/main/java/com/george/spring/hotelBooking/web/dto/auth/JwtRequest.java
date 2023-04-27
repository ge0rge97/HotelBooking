package com.george.spring.hotelBooking.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Login Request.")
public class JwtRequest {
    @Schema(description = "Username", example = "test1@test.com")
    private String username;
    @Schema(description = "Password", example = "12345")
    private String password;
}
