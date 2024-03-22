package ru.kravchenko.hw5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kravchenko.hw5.model.dto.UserProductDto;
import ru.kravchenko.hw5.service.UserProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserProductController {
    private static final Logger log = LoggerFactory.getLogger(UserProductController.class.getName());
    private final UserProductService userProductService;

    @Autowired
    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatProduct(@RequestBody UserProductDto dto) {
        log.info("Получен запрос на создание продукта: {} для пользователя с id: {} ", dto.getType(), dto.getUserId());
        userProductService.createProduct(dto);
    }

    @GetMapping("/product/{id}")
    public UserProductDto getProductById(@RequestHeader("USERID") String userId, @PathVariable int id) {
        log.info("Получен запрос продукта по id: {} для пользователя с USERID: {}", id, userId);
        return userProductService.getUserProductById(id);
    }

    @GetMapping("/products")
    public List<UserProductDto> getAllUserProductByUserId(@RequestParam(required = false) Integer userId) {
        log.info("Получен запрос продуктов для пользователя с id: {} ", userId);
        return userId == null
                ? userProductService.getAllUserProduct() : userProductService.getAllUserProductByUserId(userId);
    }

    @GetMapping("/check")
    public Boolean checkProduct(@RequestHeader("USERID") String userId, @RequestParam String type) {
        log.info("Пользователь с USERID: {} запросил проверку продукта {}", userId, type);
        return userProductService.checkProduct(Integer.valueOf(userId) ,type);
    }
}