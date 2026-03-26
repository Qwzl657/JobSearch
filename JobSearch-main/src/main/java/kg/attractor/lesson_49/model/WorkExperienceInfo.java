package kg.attractor.lesson_49.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperienceInfo {

    private int id;
    private int resumeId;
    private int years;
    private String companyName;
    private String position;
    private String responsibilities;

}