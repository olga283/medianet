package com.medianet.controller;

import com.medianet.controller.responses.AuthenticationResponse;
import com.medianet.controller.responses.DataErrorResponse;
import com.medianet.controller.responses.ProfileNotFoundResponse;
import com.medianet.controller.responses.ServerErrorResponse;
import com.medianet.controller.responses.ServiceNotAvailableResponse;
import com.medianet.model.Profile;
import com.medianet.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final ProfileService profileService;

    @GetMapping("/login")
    @Operation(summary = "Вход пользователя.",
            description = "Пользователь входит в систему под id и со своим паролем.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = "404", description = "Profile not found",
                    content = @Content(schema = @Schema(implementation = ProfileNotFoundResponse.class))),
            @ApiResponse(responseCode = "400", description = "No valid data",
                    content = @Content(schema = @Schema(implementation = DataErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ServerErrorResponse.class))),
            @ApiResponse(responseCode = "503", description = "Service Unavailable",
                    content = @Content(schema = @Schema(implementation = ServiceNotAvailableResponse.class)))
    })
    public ResponseEntity<String> login(@NotNull @RequestParam String userId, @NotNull @NotEmpty @RequestParam String password) {
        Profile profileByUserId = profileService.getProfileByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Success" + profileByUserId.getUserId());
    }
}
