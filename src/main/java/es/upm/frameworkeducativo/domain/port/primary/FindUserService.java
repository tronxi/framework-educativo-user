package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;

public interface FindUserService {
    User findUserByIdent(String ident);
    User findUserByEmail(String email);
    User findUserByIdUser(String id_user);
}
