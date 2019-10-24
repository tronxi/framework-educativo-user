package es.upm.frameworkeducativo.infrastructure.api.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserDTO {
    private String id_user;
    private String ident;
    private String name;
    private String surnames;
    private String password;
    private String email;
    private List<String> roles;
    private Boolean isChanged;
    @JsonCreator
    public UserDTO(@JsonProperty("id_user")String id_user,
                   @JsonProperty("ident")String ident,
                   @JsonProperty("name")String name,
                   @JsonProperty("surnames")String surnames,
                   @JsonProperty("password")String password,
                   @JsonProperty("email")String email,
                   @JsonProperty("roles")List<String> roles,
                   @JsonProperty("isChanged")Boolean isChanged) {
        this.id_user = id_user;
        this.ident = ident;
        this.name = name;
        this.surnames = surnames;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.isChanged = isChanged;
    }
}
