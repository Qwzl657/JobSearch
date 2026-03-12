package kg.attractor.lesson_49.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {

    private int id;
    private int typeId;
    private int resumeId;
    private String value;

}