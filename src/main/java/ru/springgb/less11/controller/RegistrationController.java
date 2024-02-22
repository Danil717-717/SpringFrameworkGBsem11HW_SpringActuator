package ru.springgb.less11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.springgb.less11.model.Session;
import ru.springgb.less11.model.User;
import ru.springgb.less11.repository.SessionRepository;
import ru.springgb.less11.service.UserService;

import static ru.springgb.less11.model.Role.USER;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final SessionRepository sessionRepository;

    public RegistrationController(UserService userService, SessionRepository sessionRepository) {
        this.userService = userService;
        this.sessionRepository = sessionRepository;
    }


    @GetMapping("/regist")
    public String getRegistUsers() {
        return "registrUser";
    }


    @PostMapping("/regist")
    public String registerUser(User user) {
        Session session = new Session("newSession");
        sessionRepository.save(session);

        user.setHashPassword(user.getPassword());
        user.setRole(USER);
        user.addSession(session);
        userService.save(user);

        return "signIn_user";
    }
}
