package es.upm.frameworkeducativo.infrastructure.api.rest.adapter;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.infrastructure.api.rest.model.UserDTO;
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

    private User userDTOToUser(UserDTO userDTO) {
        return User.builder()
                .id_user(userDTO.getId_user())
                .name(userDTO.getName())
                .surnames(userDTO.getSurnames())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .roles(userDTO.getRoles())
                .build();
    }

    private List<User>  userDTOListTOUserList(List<UserDTO> usersDTO) {
        return usersDTO.stream()
                .map(this::userDTOToUser)
                .collect(Collectors.toList());
    }

    public ResponseEntity userLoadAdapter(List<UserDTO> usersDTO) {
        List<User> user = userDTOListTOUserList(usersDTO);
        loadUserService.loadUsers(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
