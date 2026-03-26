package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    Optional<User> getByEmail(String email);

    boolean exists(String email);

    void update(User user);
}