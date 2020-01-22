package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleDAO;

public interface IRoleRepository {
    RoleDAO getRolesById(String id_role);
    String getRoleIdByDescription(String description);
    String getDescriptionByRoleId(String id_role);
}
