package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.domain.model.User;

public interface UserRepository {
    User getUserByIdent(String ident);
    User getUserByEmail(String email);
    String getUserIdByEmail(String email);
    String getUserPasswordByEmail(String email);
    void saveUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUserByIdent(String ident);
}
