package com.enifl33fi.lab4_backend.api.repository;

import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import com.enifl33fi.lab4_backend.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByUser(User user);
}
