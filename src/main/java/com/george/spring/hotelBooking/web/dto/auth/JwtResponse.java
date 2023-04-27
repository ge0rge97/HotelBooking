package com.george.spring.hotelBooking.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Login Response")
public class JwtResponse {
    @Schema(description = "User id", example = "1")
    private Long id;
    @Schema(description = "Username", example = "test1@test.com")
    private String username;
    @Schema(description = "Access Token")
    private String accessToken;
    @Schema(description = "Refresh Token")
    private String refreshToken;
}
