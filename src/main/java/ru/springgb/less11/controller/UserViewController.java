package ru.springgb.less11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.springgb.less11.service.UserService;

@Controller
public class UserViewController {


    private final UserService userService;


    @Autowired
    public UserViewController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "users_list";
    }
}
