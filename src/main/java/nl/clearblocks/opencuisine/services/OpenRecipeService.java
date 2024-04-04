package nl.clearblocks.opencuisine.services;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import nl.clearblocks.opencuisine.dto.OpenRecipeRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OpenRecipeService {

    private static final String systemMessage = "You are a chef at a restaurant that loves to come up with innovative new recipes. You are very versatile in your style.";

    private static final String userMessage = "I have the following ingredients: %s. Can you create a recipe for me that include these ingredients?";

    private final OpenAiService openAiService;

    public OpenRecipeService(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public void getOpenRecipeSuggestion(final OpenRecipeRequest openRecipeRequest) {
        String ingredients = String.join(", ", openRecipeRequest.getIngredients());
        ArrayList<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("system", systemMessage));
        messages.add(new ChatMessage("user", String.format(userMessage, ingredients)));
        ChatCompletionRequest chat = ChatCompletionRequest.builder()
                .messages(messages)
                .model("gpt-3.5-turbo")
                .build();
        openAiService.createChatCompletion(chat).getChoices().forEach(System.out::println);
    }
}
