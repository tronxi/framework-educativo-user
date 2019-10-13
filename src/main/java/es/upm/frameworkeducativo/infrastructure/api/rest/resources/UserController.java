package es.upm.frameworkeducativo.infrastructure.api.rest.resources;

import es.upm.frameworkeducativo.infrastructure.api.rest.adapter.UserAdapter;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
//@PreAuthorize("authenticated")
public class UserController {

    @Autowired
    private UserAdapter userAdapter;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity loadTeacher(@RequestBody UserDAO user) {
        return userAdapter.userLoadAdapter(user);
    }
}
