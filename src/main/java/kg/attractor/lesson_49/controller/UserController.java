package kg.attractor.lesson_49.controller;

import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // создание пользователя (пока заглушка — по ТЗ можно)
    @PostMapping
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("User created");
    }

    // поиск работодателей
    @GetMapping("/employers")
    public ResponseEntity<List<User>> findEmployers() {
        return ResponseEntity.ok(
                userService.getAllUsers().stream()
                        .filter(u -> "EMPLOYER".equals(u.getAccountType()))
                        .toList()
        );
    }

    // поиск соискателей
    @GetMapping("/applicants")
    public ResponseEntity<List<User>> findApplicants() {
        return ResponseEntity.ok(
                userService.getAllUsers().stream()
                        .filter(u -> "APPLICANT".equals(u.getAccountType()))
                        .toList()
        );
    }

    // новый endpoint (не ломает старые)
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}