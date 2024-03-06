package ru.kravchenko.hw5.model.entity;


import ru.kravchenko.hw5.model.dto.UserProductDto;

import java.math.BigDecimal;

public class UserProduct {
    private Integer id;
    private Integer userId;
    private Integer count;
    private BigDecimal balance;
    private String type;

    public UserProduct() {
    }

    public UserProduct(Integer id, Integer userId, Integer count, BigDecimal balance, String type) {
        this.id = id;
        this.userId = userId;
        this.count = count;
        this.balance = balance;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static UserProductEntity dtoToEntity(UserProductDto dto) {
        return new UserProductEntity(dto.getId(), dto.getUserId(), dto.getCount(), dto.getBalance(), dto.getType());
    }
}
