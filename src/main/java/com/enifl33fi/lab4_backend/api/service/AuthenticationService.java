package com.enifl33fi.lab4_backend.api.service;

import com.enifl33fi.lab4_backend.api.dto.request.LoginUserDto;
import com.enifl33fi.lab4_backend.api.dto.request.RegistrationUserDto;
import com.enifl33fi.lab4_backend.api.dto.response.AuthenticationResponse;
import com.enifl33fi.lab4_backend.api.exception.RefreshTokenException;
import com.enifl33fi.lab4_backend.api.mapper.UserMapper;
import com.enifl33fi.lab4_backend.api.model.security.RefreshToken;
import com.enifl33fi.lab4_backend.api.model.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;

    public AuthenticationResponse register(RegistrationUserDto userDto) {
        User user = userMapper.mapRegistrationUser(userDto);
        userService.saveUser(user);
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        refreshTokenService.saveToken(refreshToken, user);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse login(LoginUserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()
                )
        );
        User user = (User) authentication.getPrincipal();
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        refreshTokenService.saveToken(refreshToken, user);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse getAccessToken(String refreshToken) {
        if (jwtService.validateRefreshToken(refreshToken)) {
            RefreshToken token = refreshTokenService.getByToken(refreshToken);
            User user = token.getUser();
            String accessToken = jwtService.generateAccessToken(user);
            return AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .build();
        }
        refreshTokenService.deleteByToken(refreshToken);
        throw new RefreshTokenException("Invalid token");
    }

    public AuthenticationResponse refresh(String refreshToken) {
        if (jwtService.validateRefreshToken(refreshToken)) {
            RefreshToken token = refreshTokenService.getByToken(refreshToken);
            User user = token.getUser();
            String accessToken = jwtService.generateAccessToken(user);
            String newRefreshToken = jwtService.generateRefreshToken(user);
            refreshTokenService.saveToken(newRefreshToken, user);
            return AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(newRefreshToken)
                    .build();
        }
        refreshTokenService.deleteByToken(refreshToken);
        throw new RefreshTokenException("Invalid token");
    }

}
