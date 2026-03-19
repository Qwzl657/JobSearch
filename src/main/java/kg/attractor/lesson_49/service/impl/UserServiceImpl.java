package kg.attractor.lesson_49.service.impl;

import kg.attractor.lesson_49.dao.UserDao;
import kg.attractor.lesson_49.dto.UserDto;
import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public UserDto getSampleUser() {
        return UserDto.builder()
                .username("test")
                .email("test@mail.com")
                .password("123")
                .build();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}