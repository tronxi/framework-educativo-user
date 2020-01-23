package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleEntity;

import java.util.List;

public interface IUserRoleRepository {
    List<UserRoleEntity> getRolesByUserId(String id_user);
    void setRole(String id_user, String id_role);
    void deleteRoleByUserId(String id_user);
}
