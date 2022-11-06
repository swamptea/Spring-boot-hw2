package ru.swamptea.homework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
        System.out.println(msg);
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, msg, this);
    }
}
