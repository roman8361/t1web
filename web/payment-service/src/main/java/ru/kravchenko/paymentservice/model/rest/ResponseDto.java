package ru.kravchenko.paymentservice.model.rest;

import java.math.BigDecimal;

public record ResponseDto(Integer id, Integer userId, Integer count, BigDecimal balance, Type type) {
    enum Type {
        CARD, INVOICE
    }
}
