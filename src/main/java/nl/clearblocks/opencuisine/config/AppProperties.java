package nl.clearblocks.opencuisine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${rabbitmq_host}")
    private String rabbitMqHost;

    @Value("${rabbitmq_username}")
    private String rabbitMqUserName;

    @Value("${rabbitmq_password}")
    private String rabbitMqPassword;

    @Value("${openapi_key}")
    private String openApiKey;

    public String getRabbitMqHost() {
        return rabbitMqHost;
    }

    public String getRabbitMqUserName() {
        return rabbitMqUserName;
    }

    public String getRabbitMqPassword() {
        return rabbitMqPassword;
    }

    public String getOpenApiKey() {
        return openApiKey;
    }
}
