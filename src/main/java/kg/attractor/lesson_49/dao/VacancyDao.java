package kg.attractor.lesson_49.dao;

import kg.attractor.lesson_49.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VacancyDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Vacancy> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM vacancies",
                new BeanPropertyRowMapper<>(Vacancy.class)
        );
    }

    public List<Vacancy> findByCategory(String category) {
        return jdbcTemplate.query(
                "SELECT * FROM vacancies WHERE category = ?",
                new BeanPropertyRowMapper<>(Vacancy.class),
                category
        );
    }
}