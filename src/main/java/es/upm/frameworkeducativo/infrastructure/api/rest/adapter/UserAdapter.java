package es.upm.frameworkeducativo.infrastructure.api.rest.adapter;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.infrastructure.repository.RoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAdapter {

    @Autowired
    private LoadUserService loadUserService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    private User userDAOToUser(UserDAO userDAO) {
        return User.builder()
                .id_user(userDAO.getId_user())
                .name(userDAO.getName())
                .surnames(userDAO.getSurnames())
                .email(userDAO.getEmail())
                .password(userDAO.getPassword())
                .roles(userDAO.getRoles())
                .build();
    }

    private UserDAO userToUserDAO(User user) {
        return UserDAO.builder().build();
    }

    private List<String> getRolesByUser(String email) {
        String userId = userRepository.getUserIdByEmail(email);
        List<UserRoleDAO> userRoles = userRoleRepository.getRolesByUserId(userId);

        return userRoles.stream()
                .map(userRoleDAO -> roleRepository.getRolesById(userRoleDAO.getId_role()).getDescription())
                .collect(Collectors.toList());
    }

    public ResponseEntity userLoadAdapter(UserDAO userDAO) {
        User user = userDAOToUser(userDAO);
        loadUserService.loadTeacher(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
