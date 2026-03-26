package kg.attractor.lesson_49.model;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String category;
}