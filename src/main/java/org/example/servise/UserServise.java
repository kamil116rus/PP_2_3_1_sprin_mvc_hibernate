package org.example.servise;

import org.example.model.User;

import java.util.List;

public interface UserServise {

    List<User> index(Integer count);

    User show(Integer id);
    void add(User user);



}
