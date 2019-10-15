package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private UserMapper userMapper;

    public UserDAO getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public String getUserIdByEmail(String email) {
        return this.getUserByEmail(email).getId_user();
    }

    public String getUserPasswordByEmail(String email) {
        return this.getUserByEmail(email).getPassword();
    }

    public void saveUser(User user) throws Exception {
        try {
            userMapper.saveUser(user.getId_user(),
                    user.getName(), user.getSurnames(),
                    new BCryptPasswordEncoder().encode(user.getPassword()), user.getEmail());
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }

    }
}
