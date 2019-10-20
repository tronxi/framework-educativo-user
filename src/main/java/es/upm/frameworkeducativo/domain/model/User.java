package es.upm.frameworkeducativo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class User {
    private String id_user;
    private String ident;
    private String name;
    private String surnames;
    private String password;
    private String email;
    private List<String> roles;
    private Boolean isChanged;
}
