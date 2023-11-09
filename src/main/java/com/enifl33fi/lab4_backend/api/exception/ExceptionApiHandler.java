package com.enifl33fi.lab4_backend.api.exception;

import com.enifl33fi.lab4_backend.api.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({
            UsernameNotFoundException.class,
            DuplicateUsernameException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class})
    public ErrorResponse badRequestHandler(Exception e) {
        return standardResponse(e, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler({BadCredentialsException.class})
    public ErrorResponse unauthorizedHandler(Exception e) {
        return standardResponse(e, HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ErrorResponse methodNotAllowedHandler(Exception e) {
        return standardResponse(e, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ResponseBody
    @ExceptionHandler({RefreshTokenException.class})
    public ErrorResponse forbiddenHandler(Exception e) {
        return standardResponse(e, HttpStatus.FORBIDDEN);
    }

    private ErrorResponse standardResponse(Exception e, HttpStatus status) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .status(status.value())
                .statusMessage(status.getReasonPhrase())
                .build();
    }
}
