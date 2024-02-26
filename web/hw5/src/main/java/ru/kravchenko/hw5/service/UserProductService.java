package ru.kravchenko.hw5.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.hw5.model.dto.UserProductDto;
import ru.kravchenko.hw5.model.entity.UserProduct;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProductService {
    private static final Logger log = LoggerFactory.getLogger(UserProductService.class.getName());
    private final UserProductDao userProductDao;

    @Autowired
    public UserProductService(UserProductDao userProductDao) {
        this.userProductDao = userProductDao;
    }

    public void createProduct(UserProductDto dto) {
        final UserProduct userProduct = UserProduct.toUserProduct(dto);
        userProductDao.createProduct(userProduct);
        log.info("Продукт {} добавлен в БД для пользователя с id: {}", userProduct.getType(), userProduct.getUserId());
    }

    public UserProductDto getUserProductById(Long id) {
        final UserProduct userProductById = userProductDao.getUserProductById(id);
        return UserProductDto.toUserProductDto(userProductById);
    }

    public List<UserProductDto> getAllUserProductByUserId(Integer userId) {
        final List<UserProduct> allProductByUserId = userProductDao.getAllProductByUserId(userId);
        return allProductByUserId.stream()
                .map(UserProductDto::toUserProductDto)
                .collect(Collectors.toList());
    }
}
