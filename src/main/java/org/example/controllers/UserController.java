package org.example.controllers;

import org.example.servise.UserServise;
import org.example.servise.UserServiselmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServise servise;

@Autowired
    public UserController(UserServise servise) {
        this.servise = servise;
    }

    @GetMapping
    public String users(@RequestParam(value = "count", defaultValue = "5") int count,
                        Model model, UserServiselmp servise) {
    model.addAttribute("users", servise.index(count));
    return "cars";
    }
}
