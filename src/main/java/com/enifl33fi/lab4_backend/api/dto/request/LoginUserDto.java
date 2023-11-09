package com.enifl33fi.lab4_backend.api.dto.request;

import com.enifl33fi.lab4_backend.api.utils.validation.user.username.ValidUsername;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User entity for login request")
public class LoginUserDto {
    @Schema(description = "User's unique username", example = "enifl33fi")
    @ValidUsername
    private String username;
    @Schema(description = "User's password", example = "some hashed string")
    private String password;
}
