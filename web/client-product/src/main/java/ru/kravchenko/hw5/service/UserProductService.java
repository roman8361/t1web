package ru.kravchenko.hw5.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.hw5.exception.ResourceNotFoundException;
import ru.kravchenko.hw5.exception.ValidateBalanceException;
import ru.kravchenko.hw5.mapper.MapperService;
import ru.kravchenko.hw5.model.dto.UserProductDto;
import ru.kravchenko.hw5.model.entity.UserProduct;
import ru.kravchenko.hw5.model.entity.UserProductEntity;
import ru.kravchenko.hw5.repository.UserProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static ru.kravchenko.hw5.util.Constant.RESOURCE_NOT_FOUND;
import static ru.kravchenko.hw5.util.Constant.SUBZERO_BALANCE;

@Service
public class UserProductService {
    private static final Logger log = LoggerFactory.getLogger(UserProductService.class.getName());
    private final UserProductRepository userProductRepository;

    @Autowired
    public UserProductService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    public void createProduct(UserProductDto dto) {
        final UserProductEntity userProduct = UserProduct.dtoToEntity(dto);
        userProductRepository.save(userProduct);
        log.info("Продукт {} добавлен в БД для пользователя с id: {}", userProduct.getType(), userProduct.getUserId());
    }

    public UserProductDto getUserProductById(Integer id) {
        return userProductRepository.findById(id)
                .map(MapperService::entityToDto)
                .orElseThrow(() -> {
                            log.error("UserProduct с id: {} не найден", id);
                            return new ResourceNotFoundException("UserProduct с id: " + id + " не найден", RESOURCE_NOT_FOUND);
                        }
                );
    }

    public List<UserProductDto> getAllUserProductByUserId(Integer userId) {
        return userProductRepository.findAllByUserId(userId).stream()
                .map(MapperService::entityToDto)
                .collect(Collectors.toList());
    }

    public List<UserProductDto> getAllUserProduct() {
        log.info("Запрос в БД всех продуктов");
        return userProductRepository.findAll().stream()
                .map(MapperService::entityToDto)
                .collect(Collectors.toList());
    }

    public String checkProduct(Integer userId, String type) {
        return userProductRepository.findAllByUserIdAndType(userId, type).stream()
                .findFirst()
                .map(product -> {
                    if (product.getBalance().compareTo(BigDecimal.ZERO) > 0) {
                        return "[OK]";
                    } else {
                        throw new ValidateBalanceException("Баланс меньше нуля", SUBZERO_BALANCE);
                    }
                })
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ни чего не найдено", RESOURCE_NOT_FOUND));
    }
}
