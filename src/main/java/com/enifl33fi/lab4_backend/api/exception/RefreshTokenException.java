package com.enifl33fi.lab4_backend.api.exception;

public class RefreshTokenException extends RuntimeException {
    public RefreshTokenException(String message) {
        super(String.format("Failed: %s", message));
    }
}
