package kg.attractor.lesson_49.dao;

import kg.attractor.lesson_49.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    //  получить всех пользователей
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    //  найти по email (ВАЖНО: один метод!)
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        List<User> users = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(User.class),
                email
        );
        return users.stream().findFirst();
    }

    //  найти по имени
    public List<User> findByName(String name) {
        String sql = "SELECT * FROM users WHERE name = ?";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(User.class),
                name
        );
    }

    // найти по телефону
    public List<User> findByPhone(String phone) {
        String sql = "SELECT * FROM users WHERE phone_number = ?";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(User.class),
                phone
        );
    }

    //  проверка существует ли email
    public boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    //  обновление пользователя
    public void update(User user) {
        String sql = """
            UPDATE users 
            SET name = ?, surname = ?, age = ?, email = ?, phone_number = ?, avatar = ?, account_type = ?
            WHERE id = ?
        """;

        jdbcTemplate.update(sql,
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAvatar(),
                user.getAccountType(),
                user.getId()
        );
    }

    public void create(User user) {
        String sql = """
        INSERT INTO users (name, surname, age, email, password, phone_number, avatar, account_type, enabled, role_id)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, true, 2)
    """;

        jdbcTemplate.update(sql,
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getAvatar(),
                user.getAccountType()
        );
    }
}