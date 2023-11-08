package com.enifl33fi.lab4_backend.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@Deprecated(forRemoval = true)
@Tag(
        name = "Demo controller",
        description = "Only needed to verify that the authentication works"
)
public class DemoController {
    @Operation(
            summary = "Secured endpoint",
            description = "Returns data from secured endpoint"
    )
    @SecurityRequirement(name = "JWT")
    @GetMapping
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
