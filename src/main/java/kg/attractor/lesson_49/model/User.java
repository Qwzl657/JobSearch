package kg.attractor.lesson_49.model;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @Min(16)
    @Max(100)
    private Integer age;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 4, max = 24)
    private String password;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$")
    private String phoneNumber;

    private String avatar;
    private String accountType;
}