package kg.attractor.lesson_49.controller;

import kg.attractor.lesson_49.dto.UserDto;
import kg.attractor.lesson_49.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping
    public ResponseEntity<UserDto> getSampleUser(){
        return ResponseEntity.ok().body(userService.getSampleUser());
    }
}
