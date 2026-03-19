package kg.attractor.lesson_49.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResponseDao {

    private final JdbcTemplate jdbcTemplate;

    public void respond(Long userId, Long vacancyId) {
        String sql = "INSERT INTO responses (user_id, vacancy_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, vacancyId);
    }
}