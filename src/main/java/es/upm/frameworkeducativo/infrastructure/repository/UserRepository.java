package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

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

    public UserDAO saveUser(UserDAO user) {
        return userMapper.saveUser(user.getId_user(),
                user.getName(), user.getSurnames(),
                new BCryptPasswordEncoder().encode(user.getPassword()), user.getEmail());
    }
}
