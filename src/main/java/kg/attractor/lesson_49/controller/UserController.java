package kg.attractor.lesson_49.controller;

import jakarta.validation.Valid;
import kg.attractor.lesson_49.dto.UserDto;
import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody User user
    ) {
        user.setId(id);
        userService.update(user);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserDto dto) {

        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        userService.create(user);

        return ResponseEntity.status(201).build();
    }
}