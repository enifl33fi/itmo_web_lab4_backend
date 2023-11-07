package com.enifl33fi.lab4_backend.api.repository;

import com.enifl33fi.lab4_backend.api.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
