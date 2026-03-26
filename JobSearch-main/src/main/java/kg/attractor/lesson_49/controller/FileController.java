package kg.attractor.lesson_49.controller;

import kg.attractor.lesson_49.error.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @PostMapping("/avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam MultipartFile file) {

        if (file.isEmpty()) {
            throw new BadRequestException("Файл пустой");
        }

        return ResponseEntity.ok("Avatar uploaded");
    }
}