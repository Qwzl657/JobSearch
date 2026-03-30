package kg.attractor.lesson_49.service.impl;

import kg.attractor.lesson_49.dao.UserDao;
import kg.attractor.lesson_49.error.exception.BadRequestException;
import kg.attractor.lesson_49.error.exception.NotFoundException;
import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.UserService;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

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

    // ✅ НОВЫЙ МЕТОД (регистрация)
    public void create(User user) {

        if (userDao.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        log.info("Creating user: {}", user.getEmail());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.create(user);
    }

    @Override
    public void update(User user) {

        User existing = userDao.findById(user.getId())
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (!existing.getEmail().equals(user.getEmail())
                && userDao.existsByEmail(user.getEmail())) {

            throw new BadRequestException("Email уже занят");
        }

        log.warn("Updating user: {}", user.getEmail());

        userDao.update(user);
    }

    public User getByEmailOrThrow(String email) {
        return userDao.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
    }
}