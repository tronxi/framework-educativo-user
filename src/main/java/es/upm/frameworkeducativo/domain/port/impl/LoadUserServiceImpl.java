package es.upm.frameworkeducativo.domain.port.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import org.springframework.stereotype.Service;

@Service
public class LoadUserServiceImpl implements LoadUserService {
    @Override
    public void loadTeacher(User user) {
        System.out.println(user);
    }
}
