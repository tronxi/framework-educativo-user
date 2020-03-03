package es.upm.frameworkeducativo.domain.useCase

import es.upm.frameworkeducativo.domain.model.User
import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification
@Ignore
class DeleteUserServiceUseCaseTest extends Specification {
    @Shared
    UserRepositoryAdapter userRepository
    @Shared
    UserRoleRepository userRoleRepository

    @Shared
    DeleteUserService deleteUserService

    def setup() {
        userRepository = Mock(UserRepositoryAdapter)
        userRoleRepository = Mock(UserRoleRepository)

        deleteUserService = new DeleteUserServiceUseCase(userRepository, userRoleRepository)
    }

    def "delete user" () {
        given:
        String ident = "ident"
        User user = User.builder().id_user("1").build()
        userRepository.getUserByIdent(ident) >> user
        when:
        deleteUserService.deleteUser(ident)
        then:
        noExceptionThrown()
    }
}