package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleEntity;

public interface IRoleRepository {
    RoleEntity getRolesById(String id_role);
    String getRoleIdByDescription(String description);
    String getDescriptionByRoleId(String id_role);
}
