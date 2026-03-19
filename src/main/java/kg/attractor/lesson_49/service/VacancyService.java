package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.VacancyDao;
import kg.attractor.lesson_49.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyDao vacancyDao;

    public List<Vacancy> getAll() {
        return vacancyDao.findAll();
    }

    public List<Vacancy> getByCategory(String category) {
        return vacancyDao.findByCategory(category);
    }
}