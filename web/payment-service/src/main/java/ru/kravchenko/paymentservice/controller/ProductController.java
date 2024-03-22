package ru.kravchenko.paymentservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.kravchenko.paymentservice.model.rest.*;
import ru.kravchenko.paymentservice.service.ProductServiceRestClient;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class.getName());
    private final ProductServiceRestClient restClient;

    public ProductController(ProductServiceRestClient restClient) {
        this.restClient = restClient;
    }

    @PostMapping
    public ResponseDto findProduct(@RequestBody RequestDto requestDto) {
        logger.info("Получен запрос продуктов по id: {}", requestDto.id());
        return restClient.findProduct(requestDto);
    }

    @GetMapping("/check")
    public CheckResponseDto checkProduct(@RequestHeader("USERID") String userId, @RequestParam String type) {
        logger.info("Получен запрос на  проверку продукта по типу: {}", type);
        return restClient.checkProduct(userId, type);
    }
}
