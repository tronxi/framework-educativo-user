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

    @Override
    public User getUserByIdent(String ident) {
        return userDAOToUser(userMapper.getUserByIdent(ident));
    }

    public User getUserByEmail(String email) {
        return userDAOToUser(userMapper.getUserByEmail(email));
    }

    public String getUserIdByEmail(String email) {
        return this.getUserByEmail(email).getId_user();
    }

    public String getUserPasswordByEmail(String email) {
        return this.getUserByEmail(email).getPassword();
    }

    public void saveUser(User user) throws Exception {
        try {
            userMapper.saveUser(
                    user.getIdent(),
                    user.getName(), user.getSurnames(),
                    new BCryptPasswordEncoder().encode(user.getPassword()),
                    user.getEmail(), false);
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }

    }

    @Override
    public void updateUser(User user) throws Exception {
        try {
            userMapper.updateUser(
                    user.getIdent(),
                    user.getName(), user.getSurnames(),
                    new BCryptPasswordEncoder().encode(user.getPassword()),
                    user.getEmail(), user.getIsChanged(), user.getId_user());
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }
    }

    @Override
    public void deleteUserByIdent(String ident) {
        userMapper.deleteUserByIdent(ident);
    }

    private User userDAOToUser(UserDAO userDAO) {
        return User.builder()
                .id_user(userDAO.getId_user())
                .ident(userDAO.getIdent())
                .name(userDAO.getName())
                .surnames(userDAO.getSurnames())
                .password(userDAO.getPassword())
                .email(userDAO.getEmail())
                .isChanged(userDAO.getIsChanged())
                .build();
    }
}
