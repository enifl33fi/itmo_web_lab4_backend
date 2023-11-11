package com.enifl33fi.lab4_backend.api.service;

import com.enifl33fi.lab4_backend.api.dto.request.CheckResultDto;
import com.enifl33fi.lab4_backend.api.dto.response.ResponseResultDto;
import com.enifl33fi.lab4_backend.api.mapper.ResultMapper;
import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import com.enifl33fi.lab4_backend.api.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculationService {
    private final ResultService resultService;
    private final ResultMapper resultMapper;
    private final ValidatingService validatingService;

    public List<ResponseResultDto> getResultList(User user) {
        return resultMapper.mapResultListToDto(resultService.getResultsByUser(user));
    }

    public ResponseResultDto calculateResult(CheckResultDto resultDto, User user) {
        validatingService.validateEntity(resultDto);

        Result newResult = resultMapper.mapResultFromDto(resultDto, user);
        resultService.saveResult(newResult);

        return resultMapper.mapResultToDto(newResult);
    }
}
