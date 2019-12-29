package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;
import org.springframework.http.HttpStatus;

public interface UpdateUserService {
    public void updateUser(User user) throws Exception;
}
