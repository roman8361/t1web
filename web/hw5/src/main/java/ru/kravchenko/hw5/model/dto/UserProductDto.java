package ru.kravchenko.hw5.model.dto;

import ru.kravchenko.hw5.model.entity.UserProduct;

public class UserProductDto {
    private Integer id;
    private Integer userId;
    private Integer count;
    private Integer balance;
    private Type type;

    public UserProductDto(Integer id, Integer userId, Integer count, Integer balance, Type type) {
        this.id = id;
        this.userId = userId;
        this.count = count;
        this.balance = balance;
        this.type = type;
    }

    enum Type {
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
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

    public static UserProductDto toUserProductDto(UserProduct product) {
        return new UserProductDto(product.getId(), product.getUserId(), product.getCount(), product.getBalance(),
                getTypeByStr(product.getType()));
    }

    private static Type getTypeByStr(String type) {
        return type.equals("CARD") ? Type.CARD : Type.INVOICE;
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
