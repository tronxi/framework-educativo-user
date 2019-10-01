package es.upm.frameworkeducativo.infrastructure.security.service;

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

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        if ("alumno".equals(user)) {
            return this.userBuilder(user, new BCryptPasswordEncoder().encode("123456"), "STUDENT");
        } else if ("profesor".equals(user)) {
            return this.userBuilder(user, new BCryptPasswordEncoder().encode("123456"), "TEACHER");
        } else if ("admin".equals(user)) {
            return this.userBuilder(user, new BCryptPasswordEncoder().encode("123456"), "STUDENT", "TEACHER", "ADMIN");
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    private User userBuilder(String username, String password, String... roles) {
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
