package kg.attractor.lesson_49.controller;

import kg.attractor.lesson_49.model.Resume;
import kg.attractor.lesson_49.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public ResponseEntity<String> createResume() {
        return ResponseEntity.ok("Resume created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateResume(@PathVariable Long id) {
        return ResponseEntity.ok("Resume updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResume(@PathVariable Long id) {
        return ResponseEntity.ok("Resume deleted");
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAll());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Resume>> getResumesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(resumeService.getByCategory(category));
    }
}