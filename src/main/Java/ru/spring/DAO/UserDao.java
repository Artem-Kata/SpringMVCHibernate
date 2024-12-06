package ru.spring.DAO;

import org.springframework.stereotype.Component;
import ru.spring.Models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private final List<User> users;
    private static int userCount;
    {
        users = new ArrayList<>();
        users.add(new User(++userCount, "Bob"));
        users.add(new User(++userCount, "Tom"));
        users.add(new User(++userCount, "Den"));
    }

    public List<User> index () {
        return users;
    }

    public User show (int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}