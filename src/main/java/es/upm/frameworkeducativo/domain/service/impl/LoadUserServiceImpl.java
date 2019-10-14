package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadUserServiceImpl implements LoadUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void loadTeacher(User user) {
        System.out.println(user);
        try {
            userRepository.saveUser(user);
        } catch (PersistenceException e){
            System.out.println("ERROR " + e);
        }
    }
}
