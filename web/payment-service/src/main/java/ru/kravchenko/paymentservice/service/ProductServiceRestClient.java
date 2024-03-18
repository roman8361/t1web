package ru.kravchenko.paymentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.kravchenko.paymentservice.exception.RestTemplateResponseErrorHandler;
import ru.kravchenko.paymentservice.model.rest.RequestDto;
import ru.kravchenko.paymentservice.model.rest.ResponseDto;

@Service
public class ProductServiceRestClient {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceRestClient.class.getName());
    @Value("${integrations.client.url}")
    private String base;
    private final RestClient restClient;
    private final RestTemplateResponseErrorHandler errorHandler;

    public ProductServiceRestClient(RestTemplate oldRestTemplate, RestTemplateResponseErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
        this.restClient = RestClient.create(oldRestTemplate);
    }

    public ResponseDto findProduct(RequestDto request) {
            final ResponseDto response = restClient.get()
                    .uri(base + "/product/" + request.id())
                    .header("USERID", "123456")
                    .retrieve()
                    .onStatus(errorHandler)
                    .body(ResponseDto.class);
            logger.info("response: {}", response);
            return response;
    }

    public String checkProduct(String userId, String type) {
        final String response = restClient.get()
                .uri(base + "/checkProduct?type=" + type)
                .header("USERID", userId)
                .retrieve()
                .onStatus(errorHandler)
                .body(String.class);
        logger.info("response: {}", response);
        return response;
    }
}
