package es.upm.frameworkeducativo.domain.service.impl


import es.upm.frameworkeducativo.domain.port.primary.LoadUserService
import es.upm.frameworkeducativo.infrastructure.repository.IRoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.IUserRoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.RoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository
import spock.lang.Shared
import spock.lang.Specification

class LoadUserServiceImplTest extends Specification {
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

        loadUserService = new LoadUserServiceImpl(userRoleRepository,
                                                    roleRepository,
                                                    userRepository)
    }

    def "save user list" () {

    }
}
