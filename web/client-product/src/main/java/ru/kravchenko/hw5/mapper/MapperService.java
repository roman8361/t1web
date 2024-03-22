package ru.kravchenko.hw5.mapper;

import ru.kravchenko.hw5.model.dto.UserProductDto;
import ru.kravchenko.hw5.model.entity.UserProductEntity;

public class MapperService {
    public static UserProductDto entityToDto(UserProductEntity entity) {
        return new UserProductDto(entity.getId(), entity.getUserId(), entity.getCount(), entity.getBalance(),
                getTypeByStr(entity.getType()));
    }

    private static UserProductDto.Type getTypeByStr(String type) {
        return type.equals("CARD") ? UserProductDto.Type.CARD : UserProductDto.Type.INVOICE;
    }
}
