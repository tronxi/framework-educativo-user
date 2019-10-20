package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;

public interface FindUserService {
    public User findUserByIdent(String ident);
    public User findUserByEmail(String email);
    public User findUserByIdUser(String id_user);
}
