package com.medianet.controller.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Authentication error response")
public class AuthenticationResponse {
    @Schema(description = "User token", example = "12345")
    private String token;
}
