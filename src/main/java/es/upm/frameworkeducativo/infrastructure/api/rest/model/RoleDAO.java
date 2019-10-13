package es.upm.frameworkeducativo.infrastructure.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RoleDAO {
    private String id_role;
    private String description;
}
