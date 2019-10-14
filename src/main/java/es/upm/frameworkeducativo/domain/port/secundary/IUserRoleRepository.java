package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;

import java.util.List;

public interface IUserRoleRepository {
    public List<UserRoleDAO> getRolesByUserId(String id_user);
}
