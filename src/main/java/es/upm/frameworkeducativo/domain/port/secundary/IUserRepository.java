package es.upm.frameworkeducativo.domain.port.secundary;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.apache.ibatis.exceptions.PersistenceException;

public interface IUserRepository {
    public UserDAO getUserByEmail(String email);
    public String getUserIdByEmail(String email);
    public String getUserPasswordByEmail(String email);
    public void saveUser(User user) throws PersistenceException;
}
