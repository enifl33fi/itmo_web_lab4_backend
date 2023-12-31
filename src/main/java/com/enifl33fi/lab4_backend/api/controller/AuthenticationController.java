package com.enifl33fi.lab4_backend.api.controller;

import com.enifl33fi.lab4_backend.api.dto.request.LoginUserDto;
import com.enifl33fi.lab4_backend.api.dto.request.RefreshJwtRequest;
import com.enifl33fi.lab4_backend.api.dto.request.RegistrationUserDto;
import com.enifl33fi.lab4_backend.api.dto.response.AuthenticationResponse;
import com.enifl33fi.lab4_backend.api.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

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
            summary = "Receiving accept and refresh token",
            description = "Allows to receive new accept and refresh token"
    )
    @PostMapping("/refresh")
    @ResponseBody
    public AuthenticationResponse getToken(
            @RequestBody RefreshJwtRequest request
    ) {
        return authenticationService.getTokens(request.getRefreshToken());
    }

    @GetMapping("/unique")
    @ResponseBody
    public Map<String, Boolean> isUserUnique(@RequestParam("username") String username) {
        Boolean isUnique = authenticationService.isUserUnique(username);
        return Collections.singletonMap("unique", isUnique);
    }

}
