package ru.swamptea.homework2.service;

import org.springframework.stereotype.Component;
import ru.swamptea.homework2.exception.InvalidCredentials;
import ru.swamptea.homework2.exception.UnauthorizedUser;
import ru.swamptea.homework2.repository.Authorities;
import ru.swamptea.homework2.repository.UserRepository;
import ru.swamptea.homework2.user.User;

import java.util.List;

@Component
public class AuthorizationService {

    final
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getLogin()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getLogin(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getLogin());
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
