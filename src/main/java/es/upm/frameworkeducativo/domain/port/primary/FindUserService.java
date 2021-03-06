package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;

import java.util.List;

public interface FindUserService {
    User findUserByIdent(String ident);
    User findUserByIdUser(String id_user);
    List<User> findListUserByIdUser(List<String> listId);
    List<User> findListUserByRole(String role);
    List<User> findListAllUsers();

}
