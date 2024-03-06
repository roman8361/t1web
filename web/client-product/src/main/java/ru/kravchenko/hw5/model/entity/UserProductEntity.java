package ru.kravchenko.hw5.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "user_product")
public class UserProductEntity {
    @Id
    private Integer id;
    private Integer userId;
    private Integer count;
    private BigDecimal balance;
    private String type;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserEntity userEntity;

    public UserProductEntity(Integer id, Integer userId, Integer count, BigDecimal balance, String type) {
        this.id = id;
        this.userId = userId;
        this.count = count;
        this.balance = balance;
        this.type = type;
    }

    public UserProductEntity() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getCount() {
        return count;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }
}
