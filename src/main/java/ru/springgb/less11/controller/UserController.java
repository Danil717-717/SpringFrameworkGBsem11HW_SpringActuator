package ru.springgb.less11.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.springgb.less11.model.User;

import java.util.List;

@RestController
public interface UserController {

    List<User> getAllUser();

    User getUserById(@PathVariable Long id);

    User createUser(@RequestBody User user);

    User updateUser(@PathVariable Long id, @RequestBody User user);

    void deleteUser(@PathVariable Long id);

    public User getUserByEmail(@PathVariable String email);
}
