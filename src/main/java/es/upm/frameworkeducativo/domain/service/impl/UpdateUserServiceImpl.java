package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.UpdateUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserService {

    private final IUserRepository userRepository;

    @Override
    public void updateUser(User user) throws Exception{
        updateUserData(user);
    }

    private void updateUserData(User user) throws Exception {
        try {
            userRepository.updateUser(user);
        } catch (Exception e) {
            throw new Exception();
        }
    }

}
