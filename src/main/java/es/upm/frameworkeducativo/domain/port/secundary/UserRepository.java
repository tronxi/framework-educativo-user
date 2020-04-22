package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.domain.model.User;

import java.util.List;

public interface UserRepository {
    User getUserByIdent(String ident);
    User getUserByEmail(String email);
    User getUserByIdUser(String idUser);
    String getUserIdByEmail(String email);
    String getUserPasswordByEmail(String email);
    List<User> getUserListByRole(String role);
    List<User> getAllUsers();
    void saveUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUserByIdent(String ident);
}
