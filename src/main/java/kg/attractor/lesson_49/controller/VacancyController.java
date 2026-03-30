package kg.attractor.lesson_49.controller;

import kg.attractor.lesson_49.model.Vacancy;
import kg.attractor.lesson_49.model.User;
import kg.attractor.lesson_49.service.VacancyService;
import kg.attractor.lesson_49.service.ResponseService;
import kg.attractor.lesson_49.dao.UserDao;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;
    private final ResponseService responseService;
    private final UserDao userDao;

    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody Vacancy vacancy,
            Authentication auth
    ) {
        String email = auth.getName();

        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vacancy.setUserId(user.getId());

        vacancyService.create(vacancy);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/{id}/respond")
    public ResponseEntity<String> respondVacancy(
            @PathVariable Long id,
            Authentication auth
    ) {
        String email = auth.getName();

        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        responseService.respond(user.getId(), id);

        return ResponseEntity.ok("Responded successfully");
    }
}