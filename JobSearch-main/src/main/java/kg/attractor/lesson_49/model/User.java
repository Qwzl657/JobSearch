package kg.attractor.lesson_49.model;

import lombok.*;

import jakarta.validation.constraints.*;

public class User {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Min(16)
    private Integer age;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String phoneNumber;

    private String avatar;

    private String accountType;
}