package com.enifl33fi.lab4_backend.api.mapper;

import com.enifl33fi.lab4_backend.api.dto.request.CheckResultDto;
import com.enifl33fi.lab4_backend.api.dto.response.ResponseResultDto;
import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import com.enifl33fi.lab4_backend.api.model.user.User;
import com.enifl33fi.lab4_backend.api.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultMapper {
    private final CheckService checkService;

    public Result mapResultFromDto(CheckResultDto resultDto, User user) {
        long startTime = System.currentTimeMillis();
        Result newResult = Result.builder()
                .user(user)
                .x(resultDto.getX())
                .y(resultDto.getY())
                .r(resultDto.getR())
                .hit(checkService.isInArea(
                        resultDto.getX(),
                        resultDto.getY(),
                        resultDto.getR()))
                .curDate(System.currentTimeMillis())
                .build();
        long currentTime = System.currentTimeMillis();
        newResult.setScriptTime(currentTime - startTime);
        return newResult;
    }

    public ResponseResultDto mapResultToDto(Result result) {
        return ResponseResultDto.builder()
                .id(result.getId())
                .x(result.getX())
                .y(result.getY())
                .r(result.getR())
                .hit(result.getHit())
                .curDate(result.getCurDate())
                .scriptTime(result.getScriptTime())
                .build();
    }

    public List<ResponseResultDto> mapResultListToDto(List<Result> results) {
        return results.stream()
                .map(this::mapResultToDto)
                .toList();
    }
}
