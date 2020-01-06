package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    @Autowired
    public DeleteUserServiceImpl(UserRepository userRepository,
                                 UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
    @Override
    public void deleteUser(String ident) {
        String id_user = userRepository.getUserByIdent(ident).getId_user();
        userRoleRepository.deleteRoleByUserId(id_user);
        userRepository.deleteUserByIdent(ident);
    }
}
