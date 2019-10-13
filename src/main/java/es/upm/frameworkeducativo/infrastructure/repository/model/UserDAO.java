package es.upm.frameworkeducativo.infrastructure.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
@Builder
public class UserDAO {
    private String id_user;
    private String name;
    private String surnames;
    private String password;
    private String email;
    private List<String> roles;
}
