package ru.kravchenko.hw5;

import org.junit.jupiter.api.Test;
import ru.kravchenko.hw5.model.dto.UserProductDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

class AppTest {

    @Test
    void contextLoads() {
        final List<UserProductDto> userProductDto = getUserProductDto();
        final String result = userProductDto.stream()
                .findFirst()
                .map(product -> {
                    if (product.getBalance().compareTo(BigDecimal.ZERO) > 0) {
                        return "[OK]";
                    } else {
                        throw new IllegalStateException("Ни одно из полей не больше 0");
                    }
                })
                .orElseThrow(() -> new IllegalStateException("Коллекция товаров пуста"));

        System.out.println(result);
    }

    private List<UserProductDto> getUserProductDto() {
        return Arrays.asList(
                new UserProductDto(1, 2, 3, BigDecimal.valueOf(2111), UserProductDto.Type.CARD),
                new UserProductDto(2, 2, 3, BigDecimal.valueOf(2222), UserProductDto.Type.INVOICE),
                new UserProductDto(3, 1, 3, BigDecimal.valueOf(21), UserProductDto.Type.INVOICE),
                new UserProductDto(4, 1, 3, BigDecimal.valueOf(1222), UserProductDto.Type.CARD),
                new UserProductDto(5, 3, 3, BigDecimal.valueOf(0), UserProductDto.Type.INVOICE)
        );
    }

}
