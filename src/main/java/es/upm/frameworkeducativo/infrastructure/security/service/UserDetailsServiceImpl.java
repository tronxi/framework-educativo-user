package es.upm.frameworkeducativo.infrastructure.security.service;

import es.upm.frameworkeducativo.infrastructure.repository.RoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter;
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryAdapter userRepositoryAdapter;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        if (userRepositoryAdapter.getUserByEmail(user) != null) {
            return this.userBuilder(user, this.getUserPassword(user), this.getRolesByUser(user));
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    private String getUserPassword(String user) {
        return userRepositoryAdapter.getUserPasswordByEmail(user);
    }

    private List<String> getRolesByUser(String user) {
        String userId = userRepositoryAdapter.getUserIdByEmail(user);
        List<UserRoleEntity> userRoles = userRoleRepository.getRolesByUserId(userId);

        return userRoles.stream()
                .map(userRoleEntity -> roleRepository.getRolesById(userRoleEntity.getId_role()).getDescription())
                .collect(Collectors.toList());
    }

    private User userBuilder(String username, String password, List<String> roles) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}