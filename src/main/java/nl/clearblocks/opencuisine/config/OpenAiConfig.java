package nl.clearblocks.opencuisine.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {
    @Bean
    OpenAiService openAiService(AppProperties appProperties) {
        return new OpenAiService(appProperties.getOpenApiKey());
    }
}
