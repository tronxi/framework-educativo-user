package es.upm.frameworkeducativo.infrastructure.security.service;

import es.upm.frameworkeducativo.infrastructure.repository.RoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        if (userRepository.getUserByEmail(user) != null) {
            return this.userBuilder(user, this.getUserPassword(user), this.getRolesByUser(user));
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    private String getUserPassword(String user) {
        return userRepository.getUserPasswordByEmail(user);
        //return new BCryptPasswordEncoder().encode(userRepository.getUserPasswordByEmail(user));
    }

    private List<String> getRolesByUser(String user) {
        String userId = userRepository.getUserIdByEmail(user);
        List<UserRoleDAO> userRoles = userRoleRepository.getRolesByUserId(userId);

        return userRoles.stream()
                .map(userRoleDAO -> roleRepository.getRolesById(userRoleDAO.getId_role()).getDescription())
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