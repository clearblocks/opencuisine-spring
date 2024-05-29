package nl.clearblocks.opencuisine.services;

import nl.clearblocks.opencuisine.dto.OpenRecipeRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    private final OpenRecipeService openRecipeService;

    public RabbitMQService(RabbitTemplate rabbitTemplate, OpenRecipeService openRecipeService) {
        this.rabbitTemplate = rabbitTemplate;
        this.openRecipeService = openRecipeService;
    }

//    @Bean
//    Queue queue() {
//        System.out.println("Calling queue");
//        return new Queue(queueName, false);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        System.out.println("Calling exchange");
//        return new TopicExchange(topicExchangeName);
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        System.out.println("Calling binding");
//        return BindingBuilder.bind(queue).to(exchange).with("opencuisine");
//    }


    @RabbitListener(queues = "opencuisine", messageConverter = "jsonConverter")
    public void processMessage(final OpenRecipeRequest openRecipeRequest) {
        System.out.println(String.format("Received message: %s", openRecipeRequest.ingredients()));
        openRecipeService.getOpenRecipeSuggestion(openRecipeRequest);
    }

    public void publishOpenRecipeMessage(final OpenRecipeRequest openRecipeRequest) {
        rabbitTemplate.convertAndSend("opencuisine", "opencuisine", openRecipeRequest);
    }

}
