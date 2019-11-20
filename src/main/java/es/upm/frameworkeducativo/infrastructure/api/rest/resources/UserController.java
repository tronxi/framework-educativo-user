package es.upm.frameworkeducativo.infrastructure.api.rest.resources;

import es.upm.frameworkeducativo.infrastructure.api.rest.adapter.UserAdapter;
import es.upm.frameworkeducativo.infrastructure.api.rest.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service/user")
@PreAuthorize("authenticated")
public class UserController {

    @Autowired
    private UserAdapter userAdapter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity loadUsers(@RequestBody List<UserDTO> users) {
        return userAdapter.userLoadAdapter(users);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUsers(@RequestParam String ident) {
        return userAdapter.getUserByIdentAdapter(ident);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        return userAdapter.updateUserAdapter(userDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping()
    public ResponseEntity deleteUser(@RequestParam String ident) {
        return userAdapter.deleteUserByIdent(ident);
    }

}
