package kg.attractor.lesson_49.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @PostMapping("/avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam MultipartFile file) {
        return ResponseEntity.ok("Avatar uploaded");
    }
}