package es.upm.frameworkeducativo.infrastructure.event.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.infrastructure.event.model.DeletedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void deleteUserEvent(User user) {
        DeletedUser deletedUser = toUserDeleted(user);
        try {
            String deletedUserString = objectMapper.writeValueAsString(deletedUser);
            rabbitTemplate.convertAndSend("user.deleted", "", deletedUserString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private DeletedUser toUserDeleted(User user) {
        return DeletedUser.builder()
                .id_user(user.getId_user())
                .roles(user.getRoles())
                .build();
    }
}
