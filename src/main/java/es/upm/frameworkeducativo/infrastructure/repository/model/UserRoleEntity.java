package es.upm.frameworkeducativo.infrastructure.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class UserRoleEntity {
    private String id_user;
    private String id_role;
}
