package com.medianet.controller.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "Get user response")
public class UserResponse {
    @Schema(description = "User ID", example = "12345")
    private String user_id;

    @Schema(description = "User name", example = "Peter")
    private String first_name;

    @Schema(description = "User lastname", example = "Pen")
    private String second_name;

    @Schema(description = "The date of birth", example = "2003-03-03")
    private Date birthdate;

    @Schema(description = "User history", example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
    private String biography;

    @Schema(description = "Users city", example = "Samara")
    private String city;
}
