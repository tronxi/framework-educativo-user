package es.upm.frameworkeducativo.infrastructure.repository.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RoleEntity {
    private String id_role;
    private String description;
}
