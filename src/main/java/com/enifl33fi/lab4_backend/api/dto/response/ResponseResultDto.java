package com.enifl33fi.lab4_backend.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity mapped from result ")
public class ResponseResultDto {
    @Schema(description = "Id of provided result")
    private Long id;
    @Schema(description = "x coordinate")
    private Double x;
    @Schema(description = "y coordinate")
    private Double y;
    @Schema(description = "radius")
    private Double r;
    @Schema(description = "Date when given result was performed")
    private Long curDate;
    @Schema(description = "Time of calculating script")
    private Long scriptTime;
    @Schema(description = "Result of hitting")
    private Boolean hit;

}
