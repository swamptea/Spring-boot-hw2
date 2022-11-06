package ru.swamptea.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    Map<Map<String, String>, List<Authorities>> users = new HashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        Map<String, String> map = new HashMap<>();
        map.put(user, password);
        if (users.containsKey(map))
            return users.get(map);
        else return new ArrayList<>();
    }
}
