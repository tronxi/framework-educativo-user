package es.upm.frameworkeducativo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Builder
public class User {
    private String id_user;
    private String name;
    private String surnames;
    private String password;
    private String email;
    private List<String> roles;
}
