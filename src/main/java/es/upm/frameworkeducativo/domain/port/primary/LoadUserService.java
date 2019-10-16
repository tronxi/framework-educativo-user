package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.User;

import java.util.List;

public interface LoadUserService {
    public void loadUsers(List<User> user);
}
