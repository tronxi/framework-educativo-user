package es.upm.frameworkeducativo.domain.useCase

import es.upm.frameworkeducativo.domain.port.primary.LoadUserService
import es.upm.frameworkeducativo.infrastructure.repository.*
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

@Ignore
class LoadUserServiceUseCaseTest extends Specification {
    @Shared
    es.upm.frameworkeducativo.domain.port.secundary.UserRepository userRepository
    @Shared
    IRoleRepository roleRepository
    @Shared
    IUserRoleRepository userRoleRepository

    @Shared
    LoadUserService loadUserService

    def setup() {
        userRepository = Mock(UserRepositoryAdapter)
        roleRepository = Mock(RoleRepository)
        userRoleRepository = Mock(UserRoleRepository)

        loadUserService = new LoadUserServiceUseCase(userRoleRepository,
                                                    roleRepository,
                                                    userRepository)
    }

    def "save user list" () {

    }
}
