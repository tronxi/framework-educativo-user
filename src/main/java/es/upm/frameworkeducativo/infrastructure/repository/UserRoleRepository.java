package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.port.secundary.IUserRoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserRoleMapper;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleRepository implements IUserRoleRepository {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleDAO> getRolesByUserId(String id_user) {
        return userRoleMapper.getRoleByUserId(id_user);
    }

    @Override
    public void setRole(String id_user, String id_role) {
        userRoleMapper.insertUserRole(id_user, id_role);
    }
}
