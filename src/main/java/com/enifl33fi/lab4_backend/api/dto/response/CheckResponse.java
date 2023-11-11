package com.enifl33fi.lab4_backend.api.dto.response;

import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity with last checked result")
public class CheckResponse {
    @Schema(description = "Last checked result")
    private ResponseResultDto checkedResult;
}
