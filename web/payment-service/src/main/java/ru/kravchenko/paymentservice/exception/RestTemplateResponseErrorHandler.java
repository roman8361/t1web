package ru.kravchenko.paymentservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.kravchenko.paymentservice.model.error.IntegrationErrorDto;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError()) {
            ObjectMapper objectMapper = new ObjectMapper();
            IntegrationErrorDto integrationErrorDto = objectMapper.readValue(response.getBody(), IntegrationErrorDto.class);
            throw new IntegrationException("Произошла ошибка при интеграции с сервисом - исполнителем платежей", integrationErrorDto);
        }
    }
}