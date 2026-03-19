package kg.attractor.lesson_49.dao;

import kg.attractor.lesson_49.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResumeDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Resume> findAll() {
        return jdbcTemplate.query("SELECT * FROM resumes",
                new BeanPropertyRowMapper<>(Resume.class));
    }

    public List<Resume> findByCategory(String category) {
        return jdbcTemplate.query(
                "SELECT * FROM resumes WHERE category = ?",
                new BeanPropertyRowMapper<>(Resume.class),
                category
        );
    }

    public List<Resume> findByUserId(Long userId) {
        return jdbcTemplate.query(
                "SELECT * FROM resumes WHERE user_id = ?",
                new BeanPropertyRowMapper<>(Resume.class),
                userId
        );
    }
}