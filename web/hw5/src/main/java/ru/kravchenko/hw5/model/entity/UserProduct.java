package ru.kravchenko.hw5.model.entity;


import ru.kravchenko.hw5.model.dto.UserProductDto;

public class UserProduct {
    private Integer id;
    private Integer userId;
    private Integer count;
    private Integer balance;
    private String type;

    public UserProduct() {
    }

    public UserProduct(Integer id, Integer userId, Integer count, Integer balance, String type) {
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static UserProduct toUserProduct(UserProductDto dto) {
        return new UserProduct(dto.getId(), dto.getUserId(), dto.getCount(), dto.getBalance(), dto.getType());
    }
}
