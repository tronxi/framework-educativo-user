package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.port.secundary.IRoleRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.model.RoleDAO;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.RoleMapper;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleRepository implements IRoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDAO getRolesById(String id_role) {
        return roleMapper.getRoleById(id_role);
    }

    @Override
    public String getRoleIdByDescription(String description) {
        return roleMapper.getRoleByDescription(description);
    }

}
