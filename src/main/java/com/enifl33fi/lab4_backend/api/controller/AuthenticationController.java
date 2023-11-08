package com.enifl33fi.lab4_backend.api.controller;

import com.enifl33fi.lab4_backend.api.dto.request.LoginUserDto;
import com.enifl33fi.lab4_backend.api.dto.request.RefreshJwtRequest;
import com.enifl33fi.lab4_backend.api.dto.request.RegistrationUserDto;
import com.enifl33fi.lab4_backend.api.dto.response.AuthenticationResponse;
import com.enifl33fi.lab4_backend.api.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Authentication controller",
        description = "Allows to register, log in, and update access and refresh keys"
)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(
            summary = "User registration",
            description = "Registration ONLY for users"
    )
    @PostMapping("/register")
    @ResponseBody
    public AuthenticationResponse register(
            @RequestBody RegistrationUserDto userDto
    ) {
        return authenticationService.register(userDto);
    }

    @Operation(
            summary = "Login",
            description = "Allows to log in"
    )
    @PostMapping("/login")
    @ResponseBody
    public AuthenticationResponse login(
            @RequestBody LoginUserDto userDto
    ) {
        return authenticationService.login(userDto);
    }

    @Operation(
            summary = "Receiving accept token",
            description = "Allows to receive new accept token"
    )
    @PostMapping("/token")
    @ResponseBody
    public AuthenticationResponse getToken(
            @RequestBody RefreshJwtRequest request
    ) {
        return authenticationService.getAccessToken(request.getRefreshToken());
    }

    @Operation(
            summary = "Receiving refresh and accept tokens",
            description = "Allows to receive new refresh and accept tokens"
    )
    @SecurityRequirement(name = "JWT")
    @PostMapping("/refresh")
    @ResponseBody
    public AuthenticationResponse refresh(
            @RequestBody RefreshJwtRequest request
    ) {
        return authenticationService.refresh(request.getRefreshToken());
    }
}
