package com.enifl33fi.lab4_backend.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity with exception message and error status")
public class ErrorResponse {
    @Schema(description = "Exception that was handled message")
    private String message;
    @Schema(description = "Status code")
    private int status;
    @Schema(description = "Status message")
    private String statusMessage;
}
