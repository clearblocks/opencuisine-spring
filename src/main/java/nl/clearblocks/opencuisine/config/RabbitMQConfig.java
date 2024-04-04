package nl.clearblocks.opencuisine.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    static final String topicExchangeName = "opencuisine";

    static final String queueName = "opencuisine";

    @Bean
    ConnectionFactory connectionFactory(AppProperties appProperties) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(appProperties.getRabbitMqHost());
        connectionFactory.setUsername(appProperties.getRabbitMqUserName());
        connectionFactory.setPassword(appProperties.getRabbitMqPassword());
        return connectionFactory;
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
