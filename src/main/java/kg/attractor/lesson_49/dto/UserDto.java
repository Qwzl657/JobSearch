package kg.attractor.lesson_49.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Username не должен быть пустым")
    @Size(min = 2, max = 50, message = "Username от 2 до 50 символов")
    private String username;

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 4, max = 24, message = "Пароль 4-24 символа")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).+$",
            message = "Пароль должен содержать цифру и заглавную букву"
    )
    private String password;

    @NotBlank(message = "Email обязателен")
    @Email(message = "Неверный формат email")
    private String email;
}
