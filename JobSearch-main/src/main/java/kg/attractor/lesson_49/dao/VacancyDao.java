package kg.attractor.lesson_49.dao;

import kg.attractor.lesson_49.model.Vacancy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyDao {

    private final JdbcTemplate jdbcTemplate;
    public void create(Vacancy v) {
        jdbcTemplate.update(
                "INSERT INTO vacancies (user_id, name, category) VALUES (?, ?, ?)",
                v.getUserId(),
                v.getName(),
                v.getCategory()
        );
    }

    public void update(Vacancy v) {
        jdbcTemplate.update(
                "UPDATE vacancies SET name = ?, category = ? WHERE id = ?",
                v.getName(),
                v.getCategory(),
                v.getId()
        );
    }

    public void delete(Long id) {
        jdbcTemplate.update(
                "DELETE FROM vacancies WHERE id = ?",
                id
        );
    }
    public VacancyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vacancy> findAll() {
        return jdbcTemplate.query("SELECT * FROM vacancies",
                new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<Vacancy> findByCategory(String category) {
        return jdbcTemplate.query("SELECT * FROM vacancies WHERE category = ?",
                new BeanPropertyRowMapper<>(Vacancy.class), category);

    }
}