package kg.attractor.lesson_49.service.impl;

import kg.attractor.lesson_49.dao.UserDao;
import kg.attractor.lesson_49.error.exception.BadRequestException;
import kg.attractor.lesson_49.error.exception.NotFoundException;
import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
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
    public void update(User user) {

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new BadRequestException("Email не может быть пустым");
        }

        if (!userDao.existsByEmail(user.getEmail())) {
            throw new NotFoundException("Пользователь с таким email не найден");
        }

        userDao.update(user);
    }
    public User getByEmailOrThrow(String email) {
        return userDao.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
    }
}