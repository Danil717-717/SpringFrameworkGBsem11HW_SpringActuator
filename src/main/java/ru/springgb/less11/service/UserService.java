package ru.springgb.less11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springgb.less11.model.Session;
import ru.springgb.less11.model.User;
import ru.springgb.less11.repository.SessionRepository;
import ru.springgb.less11.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionService sessionService;
    private SessionRepository sessionRepository;

    public User save(User user) {
        return userRepository.save(user);
    }


    public User updateUser(Long id, User user) {
        User existingUser = findById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }



    public User assignSession(Long id, Session session) {
        User user = findById(id);
        user.addSession(session);
        return userRepository.save(user);
    }


}
