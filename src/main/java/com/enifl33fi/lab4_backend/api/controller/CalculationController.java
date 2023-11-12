package com.enifl33fi.lab4_backend.api.controller;

import com.enifl33fi.lab4_backend.api.dto.request.CheckResultDto;
import com.enifl33fi.lab4_backend.api.dto.response.CheckResponse;
import com.enifl33fi.lab4_backend.api.dto.response.HistoryResponse;
import com.enifl33fi.lab4_backend.api.model.user.User;
import com.enifl33fi.lab4_backend.api.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Tag(
        name = "Calculation controller",
        description = "Allows to get previous calculations and to check new ones"
)
@RestController
@RequestMapping("/api/calc")
@RequiredArgsConstructor
public class CalculationController {
    private final CalculationService calculationService;

    @Operation(
            summary = "Get previous result",
            description = "Returns collection of previous results for current principal"
    )
    @SecurityRequirement(name = "JWT")
    @GetMapping("/history")
    @ResponseBody
    public HistoryResponse getHistory(Authentication authentication) {
        return HistoryResponse.builder()
                .results(calculationService.getResultList((User) authentication.getPrincipal()))
                .build();
    }

    @Operation(
            summary = "Check current try and return results",
            description = "Forms and returns single result from data that was send"
    )
    @SecurityRequirement(name = "JWT")
    @PostMapping("/check")
    public CheckResponse check(@RequestBody CheckResultDto resultDto,
                               Authentication authentication) {
        return CheckResponse.builder()
                .checkedResult(calculationService.calculateResult(resultDto, (User) authentication.getPrincipal()))
                .build();
    }

}
