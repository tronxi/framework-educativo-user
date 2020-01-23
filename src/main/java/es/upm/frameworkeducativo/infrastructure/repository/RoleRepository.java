package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleEntity;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleRepository implements IRoleRepository {

    private final RoleMapper roleMapper;

    @Override
    public RoleEntity getRolesById(String id_role) {
        return roleMapper.getRoleById(id_role);
    }

    @Override
    public String getRoleIdByDescription(String description) {
        return roleMapper.getRoleByDescription(description);
    }

    @Override
    public String getDescriptionByRoleId(String id_role) {
        return roleMapper.getDescriptionByRoleId(id_role);
    }

}
