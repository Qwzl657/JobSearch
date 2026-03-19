package kg.attractor.lesson_49.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // создание пользователя
    @PostMapping
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("User created");
    }

    // поиск работодателей
    @GetMapping("/employers")
    public ResponseEntity<String> findEmployers() {
        return ResponseEntity.ok("Employers list");
    }

    // поиск соискателей
    @GetMapping("/applicants")
    public ResponseEntity<String> findApplicants() {
        return ResponseEntity.ok("Applicants list");
    }
}