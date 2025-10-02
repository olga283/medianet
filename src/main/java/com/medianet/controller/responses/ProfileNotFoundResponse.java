package com.medianet.controller.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Profile not found response")
public class ProfileNotFoundResponse {
    @Schema(description = "User profile not found", example = "Not found")
    private String message;
}
