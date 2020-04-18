package es.upm.frameworkeducativo.configuration;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Declarables createRabbitmqSchema() {
        return new Declarables(
                new FanoutExchange("user.deleted", true, false, null));
    }

}
