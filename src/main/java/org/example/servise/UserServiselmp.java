package org.example.servise;

import org.example.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Component
@Repository
public class UserServiselmp implements UserServise{

    private  List<User> users = new ArrayList<>();
    {
        users.add(new User("rick", "dalton", 26));
        users.add(new User("Nick", "Tusday", 15));
        users.add(new User("rex", "dino", 56));
        users.add(new User("vitor", "chernii", 36));
        users.add(new User("rock", "live", 45));
    }
    @Override
    public List<User> index(int count) {
        if(count>=5) {
            return users;
        } else {
            return users.stream().limit(count).toList();
        }
    }
}
