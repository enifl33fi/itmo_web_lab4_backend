package com.enifl33fi.lab4_backend.api.repository;

import com.enifl33fi.lab4_backend.api.model.security.RefreshToken;
import com.enifl33fi.lab4_backend.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);

    Optional<RefreshToken> findByUser(User user);

}
