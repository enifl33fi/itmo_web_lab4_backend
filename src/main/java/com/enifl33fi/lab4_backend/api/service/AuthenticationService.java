package com.enifl33fi.lab4_backend.api.service;

import com.enifl33fi.lab4_backend.api.dto.request.LoginUserDto;
import com.enifl33fi.lab4_backend.api.dto.request.RegistrationUserDto;
import com.enifl33fi.lab4_backend.api.dto.response.AuthenticationResponse;
import com.enifl33fi.lab4_backend.api.exception.DuplicateUsernameException;
import com.enifl33fi.lab4_backend.api.exception.RefreshTokenException;
import com.enifl33fi.lab4_backend.api.mapper.UserMapper;
import com.enifl33fi.lab4_backend.api.model.security.RefreshToken;
import com.enifl33fi.lab4_backend.api.model.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final ValidatingService validatingService;

    public AuthenticationResponse register(RegistrationUserDto userDto) {
        validatingService.validateEntity(userDto);
        if (!userService.isUsernameUnique(userDto.getUsername())) {
            throw new DuplicateUsernameException(userDto.getUsername());
        }

        User user = userMapper.mapUserFromRegistrationDto(userDto);
        userService.saveUser(user);
        return getResponseByUser(user);
    }

    public AuthenticationResponse login(LoginUserDto userDto) {
        validatingService.validateEntity(userDto);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()
                )
        );
        User user = (User) authentication.getPrincipal();
        return getResponseByUser(user);
    }

    public AuthenticationResponse getTokens(String refreshToken) {
        if (jwtService.validateRefreshToken(refreshToken)) {
            RefreshToken token = refreshTokenService.getByToken(refreshToken);
            User user = token.getUser();
            return getResponseByUser(user);
        }
        refreshTokenService.deleteByToken(refreshToken);
        throw new RefreshTokenException("Invalid token");
    }

    private AuthenticationResponse getResponseByUser(User user) {
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        refreshTokenService.saveToken(refreshToken, user);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
