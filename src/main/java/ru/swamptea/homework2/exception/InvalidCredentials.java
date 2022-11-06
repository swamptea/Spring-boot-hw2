package ru.swamptea.homework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg, this);
    }
}
