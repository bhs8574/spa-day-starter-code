package org.launchcode.spaday.data;


import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    public static void add(User user) {
        users.put(user.getId(), user);
    }

    public static Collection<User> getAll() {
        return users.values();
    }

    public static User getById(int id) {
        return users.get(id);
    }

}
