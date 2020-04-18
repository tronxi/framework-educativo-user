package es.upm.frameworkeducativo.infrastructure.rabbitmq;

import es.upm.frameworkeducativo.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserEvent {

    private final RabbitTemplate rabbitTemplate;

    public void deleteUserEvent(User user) {
        rabbitTemplate.convertAndSend("user.deleted", "", user);
    }
}
