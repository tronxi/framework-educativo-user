package es.upm.frameworkeducativo.infrastructure.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UserRoleDAO {
    private String id_user;
    private String id_role;
}
