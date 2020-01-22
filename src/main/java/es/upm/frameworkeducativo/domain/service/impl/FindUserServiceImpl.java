package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.FindUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserServiceImpl implements FindUserService {

    private final IUserRepository userRepository;

    @Override
    public User findUserByIdent(String ident) {
        return userRepository.getUserByIdent(ident);
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByIdUser(String id_user) {
        return null;
    }

}
