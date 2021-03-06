package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository;
import es.upm.frameworkeducativo.infrastructure.event.publisher.DeleteUserEventPublisher;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserMapperDao;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserMapperDao userMapperDao;
    private final IRoleRepository roleRepository;
    private final IUserRoleRepository userRoleRepository;
    private final DeleteUserEventPublisher deleteUserEventPublisher;

    @Override
    public User getUserByIdUser(String idUser) {
        User user = userEntityToUser(userMapperDao.getUserByIdUser(idUser));
        return setRoles(user);
    }

    @Override
    public User getUserByIdent(String ident) {
        User user = userEntityToUser(userMapperDao.getUserByIdent(ident));
        return setRoles(user);
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userEntityToUser(userMapperDao.getUserByEmail(email));
        return setRoles(user);
    }

    @Override
    public String getUserIdByEmail(String email) {
        return this.getUserByEmail(email).getId_user();
    }

    @Override
    public String getUserPasswordByEmail(String email) {
        return this.getUserByEmail(email).getPassword();
    }

    @Override
    public List<User> getUserListByRole(String role) {
        List<UserEntity> userEntityList = userMapperDao.getUserListByRole(role);
        return userEntityList.stream()
                .map(this::userEntityToUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntityList = userMapperDao.getAllUsers();
        return userEntityList.stream()
                .map(userEntity -> {
                    User user = userEntityToUser(userEntity);
                    return setRoles(user);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(User user) throws Exception {
        try {
            userMapperDao.saveUser(
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
            userMapperDao.updateUser(
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
        User user = getUserByIdent(ident);
        String id_user = user.getId_user();
        userRoleRepository.deleteRoleByUserId(id_user);
        userMapperDao.deleteUserByIdent(ident);
        deleteUserEventPublisher.deleteUserEvent(user);
    }

    private User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .id_user(userEntity.getId_user())
                .ident(userEntity.getIdent())
                .name(userEntity.getName())
                .surnames(userEntity.getSurnames())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .isChanged(userEntity.getIsChanged())
                .build();
    }

    private User setRoles(User user) {
        List<String> roles = userRoleRepository.getRolesByUserId(user.getId_user()).stream()
                .map(role -> roleRepository.getDescriptionByRoleId(role.getId_role()))
                .collect(Collectors.toList());
        user.setRoles(roles);
        return user;
    }

    private boolean setRoles(String id_user, String id_role) {
        userRoleRepository.setRole(id_user, getRole(id_role));
        return true;
    }

    private String getRole(String description) {
        return roleRepository.getRoleIdByDescription(description);
    }
}
