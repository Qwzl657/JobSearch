package kg.attractor.lesson_49.dao;

import kg.attractor.lesson_49.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ResumeDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Resume> findAll() {
        return jdbcTemplate.query("SELECT * FROM resumes",
                new BeanPropertyRowMapper<>(Resume.class));
    }

    public Optional<Resume> findById(Long id) {
        String sql = "SELECT * FROM resumes WHERE id = ?";

        List<Resume> list = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Resume.class),
                id
        );

        return list.stream().findFirst();
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