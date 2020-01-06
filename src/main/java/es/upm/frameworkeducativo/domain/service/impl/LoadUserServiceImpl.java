package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IRoleRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoadUserServiceImpl implements LoadUserService {

    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private IUserRoleRepository userRoleRepository;

    @Autowired
    public LoadUserServiceImpl(IUserRoleRepository userRoleRepository,
                               IRoleRepository roleRepository,
                               IUserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;

    }

    @Override
    public void loadUsers(List<User> user) {
        List<Boolean> list = user.stream()
                .map(this::saveUser)
                .collect(Collectors.toList());
    }

    private boolean saveUser(User user) {
        System.out.println(user);
        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        List<Boolean> list = user.getRoles().stream()
                .map(role -> setRoles(userRepository.getUserIdByEmail(user.getEmail()), role))
                .collect(Collectors.toList());
        return true;
    }

    private boolean setRoles(String id_user, String id_role) {
        userRoleRepository.setRole(id_user, getRole(id_role));
        return true;
    }

    private String getRole(String description) {
        return roleRepository.getRoleIdByDescription(description);
    }
}
