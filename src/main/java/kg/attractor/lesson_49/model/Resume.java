package kg.attractor.lesson_49.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    private Long id;
    private Long userId;
    private String name;
    private String category;
}