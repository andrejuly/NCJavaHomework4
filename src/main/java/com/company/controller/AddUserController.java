package com.company.controller;


import com.company.actions.UserActions;
import com.company.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.validation.Valid;

@Controller
public class AddUserController {

    @GetMapping("/add")
    public String addUser(User user) {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        UserActions.add(user);
        return "result";
    }

}
