package es.upm.frameworkeducativo.domain.useCase

import es.upm.frameworkeducativo.domain.model.User
import es.upm.frameworkeducativo.domain.port.primary.FindUserService
import es.upm.frameworkeducativo.domain.port.secundary.UserRepository
import es.upm.frameworkeducativo.infrastructure.repository.UserRepositoryAdapter
import spock.lang.Shared
import spock.lang.Specification

class FindUserServiceUseCaseTest extends Specification {
    @Shared
    UserRepository userRepository

    @Shared
    FindUserService findUserService

    def setup() {
        userRepository = Mock(UserRepositoryAdapter)
        findUserService = new FindUserServiceUseCase(userRepository)
    }

    def "find user by ident"() {
        given:
        String ident = "ident"
        String idUser = "1"
        List<String> roles = Arrays.asList("ROLE_ADMIN")

        User expected = User
                .builder()
                .id_user(idUser)
                .ident(ident)
                .roles(roles)
                .build()

        userRepository.getUserByIdent(ident) >> expected

        when:
        User user = findUserService.findUserByIdent(ident)
        then:
        expected == user
    }

    def "find user by idUser"() {
        given:
        String ident = "ident"
        String idUser = "1"
        List<String> roles = Arrays.asList("ROLE_ADMIN")

        User expected = User
                .builder()
                .id_user(idUser)
                .ident(ident)
                .roles(roles)
                .build()

        userRepository.getUserByIdUser(idUser) >> expected

        when:
        User user = findUserService.findUserByIdUser(idUser)
        then:
        expected == user
    }

    def "find list user by idUser list"() {
        given:
        String ident = "ident"
        String idUser = "1"
        List<String> roles = Arrays.asList("ROLE_ADMIN")

        User expected = User
                .builder()
                .id_user(idUser)
                .ident(ident)
                .roles(roles)
                .build()
        List<User> expectedList = Arrays.asList(expected)
        List<String> listId = Arrays.asList(idUser)

        userRepository.getUserByIdUser(idUser) >> expected

        when:
        List<User> user = findUserService.findListUserByIdUser(listId)
        then:
        expectedList == user
    }

    def "find list user by role"() {
        given:
        String ident = "ident"
        String idUser = "1"
        String role = "role"
        List<String> roles = Arrays.asList("ROLE_ADMIN")

        User expected = User
                .builder()
                .id_user(idUser)
                .ident(ident)
                .roles(roles)
                .build()
        List<User> expectedList = Arrays.asList(expected)

        userRepository.getUserListByRole(role) >> expectedList

        when:
        List<User> user = findUserService.findListUserByRole(role)
        then:
        expectedList == user
    }

    def "find all users"() {
        given:
        String ident = "ident"
        String idUser = "1"
        List<String> roles = Arrays.asList("ROLE_ADMIN")

        User expected = User
                .builder()
                .id_user(idUser)
                .ident(ident)
                .roles(roles)
                .build()
        List<User> expectedList = Arrays.asList(expected)

        userRepository.getAllUsers() >> expectedList

        when:
        List<User> user = findUserService.findListAllUsers()
        then:
        expectedList == user
    }
}
