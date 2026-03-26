package kg.attractor.lesson_49.controller;

import jakarta.validation.Valid;
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
    public ResponseEntity<?> create(@Valid @RequestBody Resume resume) {
        resumeService.create(resume);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Resume resume) {
        resumeService.update(resume);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        resumeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAll() {
        return ResponseEntity.ok(resumeService.getAll());
    }
}