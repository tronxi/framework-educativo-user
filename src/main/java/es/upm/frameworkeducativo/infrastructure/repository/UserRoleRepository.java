package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserRoleMapper;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleRepository implements IUserRoleRepository {

    private final UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleEntity> getRolesByUserId(String id_user) {
        return userRoleMapper.getRoleByUserId(id_user);
    }

    @Override
    public void setRole(String id_user, String id_role) {
        userRoleMapper.insertUserRole(id_user, id_role);
    }

    @Override
    public void deleteRoleByUserId(String id_user) {
        userRoleMapper.deleteUserRoleByUserId(id_user);
    }
}
