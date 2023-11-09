package com.enifl33fi.lab4_backend.api.utils.validation.user.username;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {UsernameValidator.class})
public @interface ValidUsername {
    String message() default "{validation.user.username.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
