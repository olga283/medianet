package com.medianet.controller.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Get user response")
public class RegistrationResponse {
    @Schema(description = "User ID", example = "12345")
    private String userId;
}
