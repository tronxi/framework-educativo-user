package es.upm.frameworkeducativo.infrastructure.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class UserDAO {
    private String id_user;
    private String name;
    private String surnames;
    private String password;
    private String email;
}
