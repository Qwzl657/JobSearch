package kg.attractor.lesson_49.controller;

import jakarta.validation.Valid;
import kg.attractor.lesson_49.model.Vacancy;
import kg.attractor.lesson_49.service.ResponseService;
import kg.attractor.lesson_49.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<String> createVacancy(@Valid @RequestBody Vacancy v) {
        vacancyService.create(v);
        return ResponseEntity.status(201).body("Vacancy created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVacancy(
            @PathVariable Long id,
            @Valid @RequestBody Vacancy v
    ) {
        v.setId(id);
        vacancyService.update(v);
        return ResponseEntity.ok("Vacancy updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long id) {
        vacancyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Vacancy>> getAllVacancies() {
        return ResponseEntity.ok(vacancyService.getAll());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Vacancy>> getVacanciesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(vacancyService.getByCategory(category));
    }

    @PostMapping("/{id}/respond")
    public ResponseEntity<String> respondVacancy(@PathVariable Long id) {
        responseService.respond(1L, id);
        return ResponseEntity.ok("Responded to vacancy");
    }
}