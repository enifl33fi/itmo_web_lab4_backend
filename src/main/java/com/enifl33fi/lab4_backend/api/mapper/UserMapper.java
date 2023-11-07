package com.enifl33fi.lab4_backend.api.mapper;

import com.enifl33fi.lab4_backend.api.dto.request.RegistrationUserDto;
import com.enifl33fi.lab4_backend.api.model.user.Role;
import com.enifl33fi.lab4_backend.api.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User mapRegistrationUser(RegistrationUserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .roles(Set.of(Role.USER))
                .build();
    }
}
