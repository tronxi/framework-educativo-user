package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;

import java.util.List;

public interface IUserRoleRepository {
    public List<UserRoleDAO> getRolesByUserId(String id_user);
    public void setRole(String id_user, String id_role);
    public void deleteRoleByUserId(String id_user);
}
