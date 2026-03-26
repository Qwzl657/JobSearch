package kg.attractor.lesson_49.model;

import lombok.*;

import jakarta.validation.constraints.*;

public class Resume {

    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String name;

    @NotBlank
    private String category;
}