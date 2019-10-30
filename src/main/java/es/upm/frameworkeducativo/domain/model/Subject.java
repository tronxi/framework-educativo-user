package es.upm.frameworkeducativo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Subject {
    private String id_subject;
    private String name;
    private String year;
}
