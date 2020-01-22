package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LoadUserServiceImpl implements LoadUserService {

    private final UserRepository userRepository;

    @Override
    public void loadUsers(List<User> user) {
        List<Boolean> list = user.stream()
                .map(this::saveUser)
                .collect(Collectors.toList());
    }

    private boolean saveUser(User user) {
        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return true;
    }

}
