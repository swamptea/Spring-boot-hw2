package ru.swamptea.homework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.swamptea.homework2.repository.Authorities;
import ru.swamptea.homework2.repository.UserRepository;
import ru.swamptea.homework2.exception.InvalidCredentials;
import ru.swamptea.homework2.exception.UnauthorizedUser;

import java.util.List;

@Component
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
