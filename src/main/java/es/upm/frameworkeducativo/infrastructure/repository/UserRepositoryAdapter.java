package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserMapper;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserMapper userMapper;
    private final IRoleRepository roleRepository;
    private final IUserRoleRepository userRoleRepository;

    @Override
    public User getUserByIdent(String ident) {
        User user = userDAOToUser(userMapper.getUserByIdent(ident));
        return setRoles(user);
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userDAOToUser(userMapper.getUserByEmail(email));
        return setRoles(user);
    }

    @Override
    public String getUserIdByEmail(String email) {
        return this.getUserByEmail(email).getId_user();
    }

    private User setRoles(User user) {
        List<String> roles = userRoleRepository.getRolesByUserId(user.getId_user()).stream()
                .map(role -> roleRepository.getDescriptionByRoleId(role.getId_role()))
                .collect(Collectors.toList());
        user.setRoles(roles);
        return user;
    }

    @Override
    public String getUserPasswordByEmail(String email) {
        return this.getUserByEmail(email).getPassword();
    }

    @Override
    public void saveUser(User user) throws Exception {
        try {
            userMapper.saveUser(
                    user.getIdent(),
                    user.getName(), user.getSurnames(),
                    new BCryptPasswordEncoder().encode(user.getPassword()),
                    user.getEmail(), false);
            List<Boolean> list = user.getRoles().stream()
                    .map(role -> setRoles(getUserIdByEmail(user.getEmail()), role))
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }

    }

    @Override
    public void updateUser(User user) throws Exception {
        try {
            userRoleRepository.deleteRoleByUserId(user.getId_user());
            userMapper.updateUser(
                    user.getIdent(),
                    user.getName(), user.getSurnames(),
                    new BCryptPasswordEncoder().encode(user.getPassword()),
                    user.getEmail(), user.getIsChanged(), Integer.parseInt(user.getId_user()));
            List<Boolean> list = user.getRoles().stream()
                    .map(role -> setRoles(user.getId_user(), role))
                    .collect(Collectors.toList());
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }
    }


    @Override
    public void deleteUserByIdent(String ident) {
        String id_user = getUserByIdent(ident).getId_user();
        userRoleRepository.deleteRoleByUserId(id_user);
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

    private boolean setRoles(String id_user, String id_role) {
        userRoleRepository.setRole(id_user, getRole(id_role));
        return true;
    }

    private String getRole(String description) {
        return roleRepository.getRoleIdByDescription(description);
    }
}
