package kg.attractor.lesson_49.controller;

import kg.attractor.lesson_49.model.Resume;
import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.ResumeService;
import kg.attractor.lesson_49.dao.UserDao;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;
    private final UserDao userDao;

    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody Resume resume,
            Authentication auth
    ) {
        String email = auth.getName();

        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        resume.setUserId(user.getId());

        resumeService.create(resume);
        return ResponseEntity.status(201).build();
    }
}