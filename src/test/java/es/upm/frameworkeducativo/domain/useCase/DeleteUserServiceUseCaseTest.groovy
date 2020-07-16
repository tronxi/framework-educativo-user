package es.upm.frameworkeducativo.domain.useCase


import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter
import spock.lang.Shared
import spock.lang.Specification

class DeleteUserServiceUseCaseTest extends Specification {
    @Shared
    UserRepositoryAdapter userRepository

    @Shared
    DeleteUserService deleteUserService

    def setup() {
        userRepository = Mock(UserRepositoryAdapter)

        deleteUserService = new DeleteUserServiceUseCase(userRepository)
    }

    def "delete user"() {
        given:
        String ident = "ident"
        when:
        deleteUserService.deleteUser(ident)
        then:
        1 * userRepository.deleteUserByIdent(ident)
        noExceptionThrown()
    }
}
