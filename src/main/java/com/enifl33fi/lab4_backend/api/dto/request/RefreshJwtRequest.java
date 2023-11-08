package com.enifl33fi.lab4_backend.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity with provided refresh token")
public class RefreshJwtRequest {
    @Schema(description = "Refresh token of user")
    private String refreshToken;
}
