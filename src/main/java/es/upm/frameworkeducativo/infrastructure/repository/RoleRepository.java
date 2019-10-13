package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.api.rest.model.RoleDAO;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    public RoleDAO getRolesById(String id_role) {
        return roleMapper.getRoleById(id_role);
    }
}