package com.medianet.controller;

import com.medianet.controller.responses.DataErrorResponse;
import com.medianet.controller.responses.ProfileNotFoundResponse;
import com.medianet.controller.responses.RegistrationResponse;
import com.medianet.controller.responses.ServerErrorResponse;
import com.medianet.controller.responses.ServiceNotAvailableResponse;
import com.medianet.controller.responses.UserResponse;
import com.medianet.mapper.ProfileDtoMapper;
import com.medianet.model.Profile;
import com.medianet.model.dto.ProfileDto;
import com.medianet.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileDtoMapper profileDtoMapper;

    @GetMapping("/user/get/{userId}")
    @Operation(summary = "Получение клиента.",
            description = "Получает клиента по id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "404", description = "Profile not found"
                    , content = @Content(schema = @Schema(implementation = ProfileNotFoundResponse.class))),
            @ApiResponse(responseCode = "400", description = "No valid data",
                    content = @Content(schema = @Schema(implementation = DataErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ServerErrorResponse.class))),
            @ApiResponse(responseCode = "503", description = "Service Unavailable",
                    content = @Content(schema = @Schema(implementation = ServerErrorResponse.class)))
    })
    public ResponseEntity<String> getProfileByUserId(@PathVariable String userId) {
        Profile profile = profileService.getProfileByUserId(userId);
        ProfileDto profileDto = profileDtoMapper.map(profile);
        return ResponseEntity.status(HttpStatus.OK)
                .body(profileDto.toString());
    }

    @PostMapping("/user/register")
    @Operation(summary = "Регистрация нового пользователя.",
            description = "Регистрируем новый профиль.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success",
                    content = @Content(schema = @Schema(implementation = RegistrationResponse.class))),
            @ApiResponse(responseCode = "400", description = "No valid data",
                    content = @Content(schema = @Schema(implementation = DataErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ServerErrorResponse.class))),
            @ApiResponse(responseCode = "503", description = "Service Unavailable",
                    content = @Content(schema = @Schema(implementation = ServiceNotAvailableResponse.class)))
    })
    public ResponseEntity<String> registerProfile(@RequestBody ProfileDto profileDto) {
        Profile savedProfile = profileService.saveProfile(profileDtoMapper.map(profileDto));
        String userId = savedProfile.getUserId();
        return ResponseEntity.status(HttpStatus.OK)
                .body("User registered successfully with ID: " + userId);
    }
}
