package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.UserDao;
import kg.attractor.lesson_49.error.exception.NotFoundException;
import kg.attractor.lesson_49.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder; // NEW

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder; // NEW

    @Override
    public List<User> getAll() {
        log.debug("Fetching all users");
        return userDao.findAll();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean exists(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public void create(User user) {

        log.info("Creating user: {}", user.getEmail());

        // NEW — шифрование пароля
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDao.create(user);
    }

    @Override
    public void update(User user) {

        // CHANGE — проверяем пользователя по ID (как требует преподаватель)
        if (user.getId() == null || userDao.findById(user.getId()).isEmpty()) {
            throw new NotFoundException("User not found");
        }

        log.warn("Updating user id={}", user.getId());

        userDao.update(user);
    }
}