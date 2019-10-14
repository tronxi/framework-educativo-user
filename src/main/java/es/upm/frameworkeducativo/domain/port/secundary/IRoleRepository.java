package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleDAO;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;

import java.util.List;

public interface IRoleRepository {
    public RoleDAO getRolesById(String id_role);
}
