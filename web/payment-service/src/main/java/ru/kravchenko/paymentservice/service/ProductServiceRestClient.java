package ru.kravchenko.paymentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.kravchenko.paymentservice.exception.IntegrationException;
import ru.kravchenko.paymentservice.model.rest.RequestDto;
import ru.kravchenko.paymentservice.model.rest.ResponseDto;

@Service
public class ProductServiceRestClient {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceRestClient.class.getName());
    @Value("${integrations.client.url}")
    private String base;
    private final RestTemplate restTemplate;

    public ProductServiceRestClient(RestTemplate oldRestTemplate) {
        this.restTemplate = oldRestTemplate;
    }

    public ResponseDto findProduct(RequestDto request) {
        RestClient restClient = RestClient.create(restTemplate);
        try {
            final ResponseDto response = restClient.get()
                    .uri(base + "/product/" + request.id())
                    .retrieve()
                    .body(ResponseDto.class);
            logger.info("response: {}", response);
            return response;
        } catch (IntegrationException e) {
            logger.info("error body: {}", e.getIntegrationErrorDto());
            return null;
        }
    }
}
