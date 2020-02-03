package es.upm.frameworkeducativo.infrastructure.api.rest.resources;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService;
import es.upm.frameworkeducativo.domain.port.primary.FindUserService;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.domain.port.primary.UpdateUserService;
import es.upm.frameworkeducativo.infrastructure.api.rest.mapper.UserMapper;
import es.upm.frameworkeducativo.infrastructure.api.rest.model.UserDTO;
import es.upm.frameworkeducativo.infrastructure.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service/user")
@PreAuthorize("authenticated")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapperInfrastructure;
    private final JwtService jwtService;
    private final LoadUserService loadUserService;
    private final FindUserService findUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity loadUsers(@RequestBody List<UserDTO> users) {
        List<User> user = userMapperInfrastructure.userDTOListTOUserList(users);
        loadUserService.loadUsers(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUsers(@RequestParam String ident,
                                            @RequestHeader("authorization") String header) {
        System.out.println(jwtService.user(header));
        User user = findUserService.findUserByIdent(ident);
        UserDTO userDTO = userMapperInfrastructure.userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUsersById(@PathVariable String id,
                                            @RequestHeader("authorization") String header) {
        User user = findUserService.findUserByIdUser(id);
        UserDTO userDTO = userMapperInfrastructure.userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        User user = userMapperInfrastructure.userDTOToUser(userDTO);
        try {
            updateUserService.updateUser(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping()
    public ResponseEntity deleteUser(@RequestParam String ident) {
        deleteUserService.deleteUser(ident);
        return new ResponseEntity(HttpStatus.OK);
    }

}
