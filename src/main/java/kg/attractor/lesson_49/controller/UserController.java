package kg.attractor.lesson_49.controller;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // создание пользователя
=======
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
>>>>>>> homework_51
    @PostMapping
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("User created");
    }

    // поиск работодателей
    @GetMapping("/employers")
<<<<<<< HEAD
    public ResponseEntity<String> findEmployers() {
        return ResponseEntity.ok("Employers list");
=======
    public ResponseEntity<List<User>> findEmployers() {
        return ResponseEntity.ok(
                userService.getAllUsers().stream()
                        .filter(u -> "EMPLOYER".equals(u.getAccountType()))
                        .toList()
        );
>>>>>>> homework_51
    }

    // поиск соискателей
    @GetMapping("/applicants")
<<<<<<< HEAD
    public ResponseEntity<String> findApplicants() {
        return ResponseEntity.ok("Applicants list");
=======
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
>>>>>>> homework_51
    }
}