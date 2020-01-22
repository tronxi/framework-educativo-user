package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;

import java.util.List;

public interface IUserRoleRepository {
    List<UserRoleDAO> getRolesByUserId(String id_user);
    void setRole(String id_user, String id_role);
    void deleteRoleByUserId(String id_user);
}
