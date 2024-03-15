package ru.kravchenko.hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravchenko.hw5.model.entity.UserProductEntity;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProductEntity, Integer> {
    List<UserProductEntity> findAllByUserId(Integer userId);
}
