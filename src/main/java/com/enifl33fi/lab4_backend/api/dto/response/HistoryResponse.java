package com.enifl33fi.lab4_backend.api.dto.response;

import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity with list of previous results ")
public class HistoryResponse {
    @Schema(description = "Previous result list ")
    private List<ResponseResultDto> results;
}
