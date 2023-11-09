package com.enifl33fi.lab4_backend.api.service;

import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import com.enifl33fi.lab4_backend.api.model.user.User;
import com.enifl33fi.lab4_backend.api.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;

    private List<Result> getResultsByUser(User user) {
        return resultRepository.findAllByUser(user);
    }

}
