package es.upm.frameworkeducativo.domain.useCase;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.FindUserService;
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserServiceUseCase implements FindUserService {

    private final UserRepository userRepository;

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
        return userRepository.getUserByIdUser(id_user);
    }

}