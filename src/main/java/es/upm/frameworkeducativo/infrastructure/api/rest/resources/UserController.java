package es.upm.frameworkeducativo.infrastructure.api.rest.resources;

import es.upm.frameworkeducativo.infrastructure.api.rest.mapper.UserMapperInfrastructure;
import es.upm.frameworkeducativo.infrastructure.api.rest.model.UserDTO;
import es.upm.frameworkeducativo.infrastructure.security.service.JwtService;
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
    private UserMapperInfrastructure userMapperInfrastructure;

    @Autowired
    private JwtService jwtService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity loadUsers(@RequestBody List<UserDTO> users) {
        return userMapperInfrastructure.userLoadAdapter(users);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUsers(@RequestParam String ident,
                                            @RequestHeader("authorization") String header) {
        System.out.println(jwtService.user(header));
        return userMapperInfrastructure.getUserByIdentAdapter(ident);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        return userMapperInfrastructure.updateUserAdapter(userDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping()
    public ResponseEntity deleteUser(@RequestParam String ident) {
        return userMapperInfrastructure.deleteUserByIdent(ident);
    }

}
