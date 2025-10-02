package com.medianet.controller.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Schema(description = "Server error response")
@NoArgsConstructor
@AllArgsConstructor
public class ServerErrorResponse {

    @Schema(description = "Error message", example = "Server error")
    private String message;

    @Schema(description = "Error message", example = "23456")
    private String request_id;

    @Schema(description = "HTTP status code", example = "500")
    private HttpStatus status;
}
