package com.enifl33fi.lab4_backend.api.controller;

import com.enifl33fi.lab4_backend.api.dto.request.LoginUserDto;
import com.enifl33fi.lab4_backend.api.dto.request.RefreshJwtRequest;
import com.enifl33fi.lab4_backend.api.dto.request.RegistrationUserDto;
import com.enifl33fi.lab4_backend.api.dto.response.AuthenticationResponse;
import com.enifl33fi.lab4_backend.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseBody
    public AuthenticationResponse register(
            @RequestBody RegistrationUserDto userDto
    ) {
        return authenticationService.register(userDto);
    }

    @PostMapping("/login")
    @ResponseBody
    public AuthenticationResponse login(
            @RequestBody LoginUserDto userDto
    ) {
        return authenticationService.login(userDto);
    }

    @PostMapping("/token")
    @ResponseBody
    public AuthenticationResponse getToken(
            @RequestBody RefreshJwtRequest request
            ) {
        return authenticationService.getAccessToken(request.getRefreshToken());
    }

    @PostMapping("/refresh")
    @ResponseBody
    public AuthenticationResponse refresh(
            @RequestBody RefreshJwtRequest request
    ) {
        return authenticationService.refresh(request.getRefreshToken());
    }
}
