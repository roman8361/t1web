package ru.kravchenko.hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravchenko.hw5.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
