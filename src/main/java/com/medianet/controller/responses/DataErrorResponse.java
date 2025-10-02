package com.medianet.controller.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Data error response")
@NoArgsConstructor
@AllArgsConstructor
public class DataErrorResponse {
    @Schema(description = "HTTP status code", example = "400")
    private int status;

    @Schema(description = "Error message", example = "Invalid data format")
    private String message;

}
