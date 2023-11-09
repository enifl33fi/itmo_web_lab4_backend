package com.enifl33fi.lab4_backend.api.controller;

import com.enifl33fi.lab4_backend.api.dto.response.HistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Calculation controller",
        description = "Allows to get previous calculations and to check new ones"
)
@RestController
@RequestMapping("/api/calc")
@RequiredArgsConstructor
public class CalculationController {

    @Operation(
            summary = "Get previous result",
            description = "Returns collection of previous results for current principal"
    )
    @GetMapping("/history")
    @ResponseBody
    public HistoryResponse getHistory() {
        return new HistoryResponse();
    }

}
