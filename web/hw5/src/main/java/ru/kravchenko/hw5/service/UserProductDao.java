package ru.kravchenko.hw5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kravchenko.hw5.model.entity.UserProduct;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createProduct(UserProduct product) {
        String sql = "INSERT INTO user_product (id, user_id, count, balance, type) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getUserId(), product.getCount(), product.getBalance(), product.getType());
    }

    public UserProduct getUserProductById(Long id) {
        String sql = "SELECT * FROM user_product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(UserProduct.class));
    }

    public List<UserProduct> getAllProductByUserId(Integer userId) {
        String sql = "SELECT * FROM user_product where user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(UserProduct.class));
    }
}
