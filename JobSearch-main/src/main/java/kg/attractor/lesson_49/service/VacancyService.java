package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.VacancyDao;
import kg.attractor.lesson_49.error.exception.BadRequestException;
import kg.attractor.lesson_49.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyDao vacancyDao;

    public List<Vacancy> getAll() {
        log.debug("Get all vacancies");
        return vacancyDao.findAll();
    }

    public List<Vacancy> getByCategory(String category) {
        log.info("Get vacancies by category: {}", category);
        return vacancyDao.findByCategory(category);
    }

    public void create(Vacancy v) {
        log.info("Creating vacancy: {}", v.getName());
        vacancyDao.create(v);
    }

    public void update(Vacancy v) {
        log.warn("Updating vacancy id={}", v.getId());
        vacancyDao.update(v);
    }

    public void delete(Long id) {
        log.error("Deleting vacancy id={}", id);
        vacancyDao.delete(id);
    }
    public void update(Vacancy v) {

        if (v.getId() == null) {
            throw new BadRequestException("ID обязателен");
        }

        vacancyDao.update(v);
    }
}