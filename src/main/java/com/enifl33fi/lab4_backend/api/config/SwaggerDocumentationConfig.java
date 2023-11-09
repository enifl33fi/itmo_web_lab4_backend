package com.enifl33fi.lab4_backend.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import javax.lang.model.element.Name;

@OpenAPIDefinition(
        info = @Info(
                title = "Lab4 backend",
                description = "Backend for fourth web laboratory work",
                version = "0.0.2",
                contact = @Contact (
                        name = "Markov Kirill",
                        email = "kamarkoff@gmail.com",
                        url = "https://github.com/enifl33fi"
                )
        )
)
@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)

public class SwaggerDocumentationConfig {
}
