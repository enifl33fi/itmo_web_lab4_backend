package com.enifl33fi.lab4_backend.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResultDto {
    private Long id;
    private Double x;
    private Double y;
    private Double r;
    private Long curDate;
    private Long scriptTime;
    private Boolean hit;

}
