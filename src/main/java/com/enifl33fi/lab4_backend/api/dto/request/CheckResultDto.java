package com.enifl33fi.lab4_backend.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity with coords for calculations")
public class CheckResultDto {
    @Schema(description = "x coordinate")
    @DecimalMin(value = "-3.0")
    @DecimalMax(value = "5.0")
    @NotNull
    private Double x;
    @Schema(description = "y coordinate")
    @DecimalMin(value = "-3.0")
    @DecimalMax(value = "3.0")
    @NotNull
    private Double y;
    @Schema(description = "radius")
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "5.0")
    @NotNull
    private Double r;
}
