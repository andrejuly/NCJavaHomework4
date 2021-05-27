package com.company.controller;

import com.company.actions.UserActions;
import com.company.model.SearchedUser;
import com.company.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class FindUserController {

    @GetMapping("/find")
    public String findUser(SearchedUser searchedUser) {
        return "find";
    }

    @GetMapping("/error")
    public String notFounded() {
        return "error";
    }

    @PostMapping("/find")
    public String findUser(@Valid SearchedUser searchedUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/find";
        } else {
            User findUser = UserActions.findUser(searchedUser);
            if (findUser == null) {
                return "error";
            }
            else {
                model.addAttribute("findUser", findUser);
                model.addAttribute("localDateTime", LocalDateTime.now());
                return "info";
            }
        }
    }

}
