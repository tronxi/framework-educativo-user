package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.UpdateUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IRoleRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public HttpStatus updateUser(User user) {
        System.out.println(user);
        deleteRoles(user.getId_user());
        HttpStatus status = updateUserData(user);
        List<Boolean> list = user.getRoles().stream()
                .map(role -> setRoles(user.getId_user(), role))
                .collect(Collectors.toList());
        return status;
    }

    private HttpStatus updateUserData(User user) {
        try {
            userRepository.updateUser(user);
            return HttpStatus.OK;
        } catch (Exception e) {
            System.out.println("error");
            return HttpStatus.BAD_REQUEST;
        }
    }

    private boolean setRoles(String id_user, String id_role) {
        userRoleRepository.setRole(id_user, getRole(id_role));
        return true;
    }

    private String getRole(String description) {
        return roleRepository.getRoleIdByDescription(description);
    }

    private void deleteRoles(String id_user) {
        userRoleRepository.deleteRoleByUserId(id_user);
    }
}
