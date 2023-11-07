package com.enifl33fi.lab4_backend.api.service;

import com.enifl33fi.lab4_backend.api.model.user.User;
import com.enifl33fi.lab4_backend.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User loadUserByUsername(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with provided username not found."));
        Hibernate.initialize(user.getAuthorities());
        return user;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
