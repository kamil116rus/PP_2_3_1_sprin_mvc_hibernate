package org.example.servise;

import org.example.model.User;

import java.util.List;

public interface UserServise {

    List<User> index(int count);

    User show(int id);
    void add(User user);



}
