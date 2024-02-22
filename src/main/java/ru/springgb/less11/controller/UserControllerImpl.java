package ru.springgb.less11.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.springgb.less11.model.User;
import ru.springgb.less11.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController {
    private final UserService service;

    private final MeterRegistry meterRegistry;

    @Autowired
    public UserControllerImpl(UserService service, MeterRegistry meterRegistry) {
        this.service = service;
        this.meterRegistry = meterRegistry;
    }

    @Override
    @GetMapping
    public List<User> getAllUser() {
        meterRegistry.counter("requests_to_tasks_all").increment();
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/request")
    public User getUserByEmail(@RequestParam("email") String email) {
        return service.findByEmail(email);
    }

    private static List<User> generateUserList() {
        final List<User> list = new ArrayList<>();
        list.add(new User(1L, "Us1","Us1ln","Us1Em@","123"));
        list.add(new User(2L, "Us2","Us2ln","Us2Em@","123"));

        return list;
    }
}
