package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;

public interface LoadUserService {
    public void loadTeacher(User user);
}
