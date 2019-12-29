package es.upm.frameworkeducativo.infrastructure.api.rest.mapper;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService;
import es.upm.frameworkeducativo.domain.port.primary.FindUserService;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.domain.port.primary.UpdateUserService;
import es.upm.frameworkeducativo.infrastructure.api.rest.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapperInfrastructure {

    @Autowired
    private LoadUserService loadUserService;

    @Autowired
    private FindUserService findUserService;

    @Autowired
    private UpdateUserService updateUserService;

    @Autowired
    private DeleteUserService deleteUserService;

    public ResponseEntity userLoadAdapter(List<UserDTO> usersDTO) {
        List<User> user = userDTOListTOUserList(usersDTO);
        loadUserService.loadUsers(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity updateUserAdapter(UserDTO userDTO) {
        User user = userDTOToUser(userDTO);
        try {
            updateUserService.updateUser(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<UserDTO> getUserByIdentAdapter(String ident) {
        User user = findUserService.findUserByIdent(ident);
        UserDTO userDTO = userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    public ResponseEntity deleteUserByIdent(String ident) {
        deleteUserService.deleteUser(ident);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<UserDTO> getUserByEmailAdapter(String email) {
        User user = findUserService.findUserByEmail(email);
        UserDTO userDTO =userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    private UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id_user(user.getId_user())
                .ident(user.getIdent())
                .name(user.getName())
                .surnames(user.getSurnames())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .isChanged(user.getIsChanged())
                .build();
    }

    private User userDTOToUser(UserDTO userDTO) {
        return User.builder()
                .id_user(userDTO.getId_user())
                .ident(userDTO.getIdent())
                .name(userDTO.getName())
                .surnames(userDTO.getSurnames())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .roles(userDTO.getRoles())
                .isChanged(userDTO.getIsChanged())
                .build();
    }

    private List<User>  userDTOListTOUserList(List<UserDTO> usersDTO) {
        return usersDTO.stream()
                .map(this::userDTOToUser)
                .collect(Collectors.toList());
    }
}
