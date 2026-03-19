package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dto.UserDto;
import kg.attractor.lesson_49.model.User;

import java.util.List;

public interface UserService {

    UserDto getSampleUser(); // старый метод НЕ трогаем

    List<User> getAllUsers(); // новый
}