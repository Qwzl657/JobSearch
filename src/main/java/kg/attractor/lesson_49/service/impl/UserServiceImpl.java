package kg.attractor.lesson_49.service.impl;

import kg.attractor.lesson_49.dto.UserDto;
import kg.attractor.lesson_49.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto getSampleUser(){
        UserDto user = new UserDto();
        user.setUsername("Alex");
        user.setEmail("qwe@qwe.qwe");
        user.setPassword("qwerty");
        return user;
    }

}
