package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleRepository {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<UserRoleDAO> getRolesByUserId(String id_user) {
        return userRoleMapper.getRoleByUserId(id_user);
    }
}
