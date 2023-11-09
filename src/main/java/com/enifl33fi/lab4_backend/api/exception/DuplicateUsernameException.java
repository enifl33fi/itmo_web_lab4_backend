package com.enifl33fi.lab4_backend.api.exception;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String username) {
        super(String.format("Username '%s' already exists", username));
    }
}
