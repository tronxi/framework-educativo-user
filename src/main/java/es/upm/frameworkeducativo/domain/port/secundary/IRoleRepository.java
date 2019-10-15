package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleDAO;

public interface IRoleRepository {
    public RoleDAO getRolesById(String id_role);
    public String getRoleIdByDescription(String description);
}
