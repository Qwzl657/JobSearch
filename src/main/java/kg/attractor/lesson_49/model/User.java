package kg.attractor.lesson_49.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private String phoneNumber; // будет работать с snake_case
    private String avatar;
    private String accountType;
}