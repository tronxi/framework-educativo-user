package es.upm.frameworkeducativo.domain.useCase

import es.upm.frameworkeducativo.domain.model.User
import es.upm.frameworkeducativo.domain.port.primary.UpdateUserService
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository
import spock.lang.Shared
import spock.lang.Specification

class UpdateUserServiceUseCaseTest extends Specification {

    @Shared
    UserRepository userRepository

    @Shared
    UpdateUserService updateUserService

    def setup() {
        userRepository = Mock(UserRepository)
        updateUserService = new UpdateUserServiceUseCase(userRepository)
    }

    def "should update user"() {
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
        when:
        updateUserService.updateUser(user)
        then:
        noExceptionThrown()
        1 * userRepository.updateUser(user)
    }
}
