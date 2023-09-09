package org.example.dao;

import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaolmp implements UserDao{
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(1,"rick", "dalton", 26));
        users.add(new User(2,"Nick", "Tusday", 15));
        users.add(new User(3,"rex", "dino", 56));
        users.add(new User(4,"vitor", "chernii", 36));
        users.add(new User(5,"rock", "live", 45));
    }
    @Override
    public List<User> index(int count) {
        if(count>=5) {
            return users;
        } else {
            return users.stream().limit(count).toList();
        }
    }

    @Override
    public User show(int id) {
        return users.stream().filter(User->User.getId() == id).findAny().orElse(null);
    }
}
