package es.upm.frameworkeducativo.domain.service.impl

import es.upm.frameworkeducativo.domain.model.User
import es.upm.frameworkeducativo.domain.port.primary.FindUserService
import es.upm.frameworkeducativo.infrastructure.repository.IRoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.IUserRoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.RoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository
import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO
import spock.lang.Shared
import spock.lang.Specification

class FindUserServiceImplTest extends Specification {
    @Shared
    es.upm.frameworkeducativo.domain.port.secundary.UserRepository userRepository
    @Shared
    IRoleRepository roleRepository
    @Shared
    IUserRoleRepository userRoleRepository

    @Shared
    FindUserService findUserService

    def setup() {
        userRepository = Mock(UserRepositoryAdapter)
        roleRepository = Mock(RoleRepository)
        userRoleRepository = Mock(UserRoleRepository)

        findUserService = new FindUserServiceImpl(userRepository, roleRepository, userRoleRepository)
    }

    def "find user by ident" () {
        given:
        String ident = "ident"
        String idUser = "1"
        String idRole = "1"

        List<String> roles = new ArrayList<>()
        roles.add("ROLE_ADMIN")

        UserRoleDAO userRoleDAO = UserRoleDAO.builder()
                                    .id_user(idUser)
                                    .id_role(idRole)
                                    .build()
        List<UserRoleDAO> userRoleDAOList = new ArrayList<>()
        userRoleDAOList.add(userRoleDAO)

        User user = User
                    .builder()
                    .id_user(idUser)
                    .ident(ident)
                    .roles(roles)
                    .build()

        userRoleRepository.getRolesByUserId(idUser) >> userRoleDAOList
        roleRepository.getDescriptionByRoleId(idRole) >> "ROLE_ADMIN"
        userRepository.getUserByIdent(ident) >> User.builder().id_user(idUser).ident(ident).build()

        when:
        User res = findUserService.findUserByIdent(ident)
        then:
        res == user
    }

    def "find user by email" () {
        given:
        String email = "email"
        User user = null
        when:
        User res = findUserService.findUserByEmail(email)
        then:
        user == res
    }

    def "find user by idUser" () {
        given:
        String idUser = "1"
        User user = null
        when:
        User res = findUserService.findUserByIdUser(idUser)
        then:
        user == res
    }
}
