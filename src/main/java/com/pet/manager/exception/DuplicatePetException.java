package com.pet.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "This name is already taken")
public class DuplicatePetException extends RuntimeException {
    public DuplicatePetException() {
        super("This pet already exists");
    }
    public DuplicatePetException(String message) {
        super(message);
    }
}
