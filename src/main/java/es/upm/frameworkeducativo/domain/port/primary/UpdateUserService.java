package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;
import org.springframework.http.HttpStatus;

public interface UpdateUserService {
    public HttpStatus updateUser(User user);
}
