package es.upm.frameworkeducativo.domain.useCase

import es.upm.frameworkeducativo.domain.model.User
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

class LoadUserServiceUseCaseTest extends Specification {
    @Shared
    UserRepository userRepository

    @Shared
    LoadUserService loadUserService

    def setup() {
        userRepository = Mock(UserRepositoryAdapter)

        loadUserService = new LoadUserServiceUseCase(userRepository)
    }

    def "save user list"() {
        given:
        String ident = "ident"
        String idUser = "1"
        List<String> roles = Arrays.asList("ROLE_ADMIN")

        User user = User
                .builder()
                .id_user(idUser)
                .ident(ident)
                .roles(roles)
                .build()
        List<User> userList = Arrays.asList(user)
        when:
        loadUserService.loadUsers(userList)
        then:
        userList.size() * userRepository.saveUser(_ as User)
        noExceptionThrown()

    }
}
