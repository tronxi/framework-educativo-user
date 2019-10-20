package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.domain.model.User;

public interface IUserRepository {
    public User getUserByIdent(String ident);
    public User getUserByEmail(String email);
    public String getUserIdByEmail(String email);
    public String getUserPasswordByEmail(String email);
    public void saveUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
}
