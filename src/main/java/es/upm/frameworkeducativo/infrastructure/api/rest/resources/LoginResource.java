package es.upm.frameworkeducativo.infrastructure.api.rest.resources;

import es.upm.frameworkeducativo.domain.port.secundary.UserRepository;
import es.upm.frameworkeducativo.infrastructure.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class LoginResource {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("authenticated")
    @PostMapping(value = "user-service/login")
    public String login(@AuthenticationPrincipal User activeUser) {
        List<String> roleList = activeUser.getAuthorities().stream().map
                (authority -> authority.getAuthority()).collect(Collectors.toList());
        es.upm.frameworkeducativo.domain.model.User user = userRepository.getUserByEmail(activeUser.getUsername());
        System.out.println("login");
        return jwtService.createToken(activeUser.getUsername(), roleList, user.getId_user());
    }
}
