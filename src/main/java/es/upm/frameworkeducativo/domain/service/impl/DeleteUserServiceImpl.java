package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService;
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserServiceImpl implements DeleteUserService {

    private final UserRepository userRepository;

    @Override
    public void deleteUser(String ident) {
        userRepository.deleteUserByIdent(ident);
    }
}
