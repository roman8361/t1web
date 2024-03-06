package ru.kravchenko.paymentservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.kravchenko.paymentservice.exception.RestTemplateResponseErrorHandler;

import java.time.Duration;

@Configuration
public class RestConfig {
    @Value("${integrations.client.connect-timeout}")
    private Duration connectTimeout;
    @Value("${integrations.client.read-timeout}")
    private Duration readTimeout;
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, RestTemplateResponseErrorHandler errorHandler) {
        return builder
                .setConnectTimeout(connectTimeout)
                .setReadTimeout(readTimeout)
                .errorHandler(errorHandler)
                .build();
    }
}
