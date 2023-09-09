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
@RequestMapping("/")
public class UserController {
    private final UserServiselmp servise;

@Autowired
    public UserController(UserServiselmp servise) {
        this.servise = servise;
    }

    @GetMapping("/users")
    public String users(@RequestParam(value = "count", defaultValue = "5") int count,
                        Model model, UserServiselmp servise) {
        System.out.println("dfyguhj");
    model.addAttribute("users", servise.index(count));
    return "users";
    }
}
