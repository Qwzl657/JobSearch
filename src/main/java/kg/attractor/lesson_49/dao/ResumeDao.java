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

    public Resume findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM resumes WHERE id = ?",
                new BeanPropertyRowMapper<>(Resume.class),
                id
        );
    }

    public void create(Resume resume) {
        jdbcTemplate.update(
                "INSERT INTO resumes (user_id, name, category) VALUES (?, ?, ?)",
                resume.getUserId(),
                resume.getName(),
                resume.getCategory()
        );
    }

    public void update(Resume resume) {
        jdbcTemplate.update(
                "UPDATE resumes SET name = ?, category = ? WHERE id = ?",
                resume.getName(),
                resume.getCategory(),
                resume.getId()
        );
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM resumes WHERE id = ?", id);
    }
}