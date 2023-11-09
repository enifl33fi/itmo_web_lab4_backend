package com.enifl33fi.lab4_backend.api.repository;

import com.enifl33fi.lab4_backend.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
