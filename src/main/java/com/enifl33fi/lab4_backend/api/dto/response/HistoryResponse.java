package com.enifl33fi.lab4_backend.api.dto.response;

import com.enifl33fi.lab4_backend.api.model.calculation.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {
    private List<Result> results;
}
