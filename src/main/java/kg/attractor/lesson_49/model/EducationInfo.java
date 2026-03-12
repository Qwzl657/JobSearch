package kg.attractor.lesson_49.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationInfo {

    private int id;
    private int resumeId;
    private String institution;
    private String program;
    private String startDate;
    private String endDate;
    private String degree;

}