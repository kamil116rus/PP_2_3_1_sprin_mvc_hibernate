package org.example.controllers;

import org.example.dao.UserDao;
import org.example.dao.UserDaolmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDao servise;

@Autowired
    public UserController(UserDaolmp servise) {
        this.servise = servise;
    }

    @GetMapping
    public String users(@RequestParam(value = "count", defaultValue = "5") int count,
                        Model model, UserDaolmp servise) {
        System.out.println("dfyguhj");
    model.addAttribute("users", servise.index(count));
    return "users";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute("user", servise.show(id));
    return "users/id";
    }
}
