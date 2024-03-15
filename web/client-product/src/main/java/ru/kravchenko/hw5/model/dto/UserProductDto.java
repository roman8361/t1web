package ru.kravchenko.hw5.model.dto;

import java.math.BigDecimal;

public class UserProductDto {
    private Integer id;
    private Integer userId;
    private Integer count;
    private BigDecimal balance;
    private Type type;

    public UserProductDto(Integer id, Integer userId, Integer count, BigDecimal balance, Type type) {
        this.id = id;
        this.userId = userId;
        this.count = count;
        this.balance = balance;
        this.type = type;
    }

    public enum Type {
        CARD, INVOICE
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return type.toString();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"UserProductDto\", " +
                "\"id\":" + (id == null ? "null" : "\"" + id + "\"") + ", " +
                "\"count\":" + (count == null ? "null" : "\"" + count + "\"") + ", " +
                "\"balance\":" + (balance == null ? "null" : "\"" + balance + "\"") + ", " +
                "\"type\":" + (type == null ? "null" : type) +
                "}";
    }
}
