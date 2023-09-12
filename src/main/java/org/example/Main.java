package org.example;

import org.example.model.User;
import org.example.servise.UserServiselmp;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserServiselmp users = new UserServiselmp();



        users.add(new User(1,"rick", "dalton", 26));
        users.add(new User(2,"Nick", "Tusday", 15));
        users.add(new User(3,"rex", "dino", 56));
        users.add(new User(4,"vitor", "chernii", 36));
        users.add(new User(5,"rock", "live", 45));

        users.show(4);

    }
}