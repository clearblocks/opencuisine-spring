package nl.clearblocks.opencuisine.services;

import nl.clearblocks.opencuisine.dto.OpenRecipeRequest;
import org.springframework.stereotype.Service;

@Service
public class OpenCuisineService {

    private final RabbitMQService rabbitMQService;

    public OpenCuisineService(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    public void requestOpenRecipe(final OpenRecipeRequest openRecipeRequest) {
        rabbitMQService.publishOpenRecipeMessage(openRecipeRequest);
    }
}
