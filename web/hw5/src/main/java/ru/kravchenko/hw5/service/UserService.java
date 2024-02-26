package ru.kravchenko.hw5.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.hw5.model.entity.User;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class.getName());
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(User user) {
        userDao.createUser(user);
        log.info("Пользователь {} добавлен в БД", user.getUsername());
    }

    public User getUserById(Long userId) {
        final User userById = userDao.getUserById(userId);
        log.info("Пользователь {} получен из БД по id {}", userById.getUsername(), userId);
        return userById;
    }

    public List<User> getAllUsers() {
        final List<User> allUsers = userDao.getAllUsers();
        log.info("{} пользователей в БД", allUsers.size());
        return allUsers;
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
        log.info("Пользователь с id: {} обновлён", user.getId());
    }

    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
        log.info("Пользователь с id: {} удалён из БД", userId);
    }
}
