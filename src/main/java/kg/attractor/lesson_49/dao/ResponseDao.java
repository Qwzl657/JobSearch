package kg.attractor.lesson_49.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResponseDao {

    private final JdbcTemplate jdbcTemplate;

    public ResponseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void respond(Long userId, Long vacancyId) {
        jdbcTemplate.update(
                "INSERT INTO responses (userId, vacancyId) VALUES (?, ?)",
                userId, vacancyId
        );
    }
}