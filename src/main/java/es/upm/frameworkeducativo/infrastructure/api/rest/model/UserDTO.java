package es.upm.frameworkeducativo.infrastructure.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
@Builder
public class UserDTO {
    private String id_user;
    private String ident;
    private String name;
    private String surnames;
    private String password;
    private String email;
    private List<String> roles;
    private Boolean isChanged;
}
