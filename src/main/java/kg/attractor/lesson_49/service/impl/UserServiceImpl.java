package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.UserDao;
import kg.attractor.lesson_49.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.findAll();
    }

    public Optional<User> getByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public boolean exists(String email) {
        return userDao.existsByEmail(email);
    }
}