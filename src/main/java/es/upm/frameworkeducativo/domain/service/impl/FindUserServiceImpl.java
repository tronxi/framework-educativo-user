package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.FindUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IRoleRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindUserServiceImpl implements FindUserService {
    private IUserRepository userRepository;

    private IRoleRepository roleRepository;

    private IUserRoleRepository userRoleRepository;

    @Autowired
    public FindUserServiceImpl(IUserRepository userRepository,
                               IRoleRepository roleRepository,
                               IUserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public User findUserByIdent(String ident) {
        return setRoles(userRepository.getUserByIdent(ident));
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByIdUser(String id_user) {
        return null;
    }

    private User setRoles(User user) {
        List<String> roles = userRoleRepository.getRolesByUserId(user.getId_user()).stream()
                .map(role -> getDescriptionRole(role.getId_role()))
                .collect(Collectors.toList());
        user.setRoles(roles);
        return user;
    }

    private String getDescriptionRole(String id_role) {
        return roleRepository.getDescriptionByRoleId(id_role);
    }
}
