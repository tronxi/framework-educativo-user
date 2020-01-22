package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepository;
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
