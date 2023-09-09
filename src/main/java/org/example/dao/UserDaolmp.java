package org.example.dao;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaolmp implements UserDao{
    private List<User> users= new ArrayList<>();
    @Override
    public List<User> index(int count) {
        if(count>=5) {
            return users;
        } else {
            return users.stream().limit(count).toList();
        }
    }
}
