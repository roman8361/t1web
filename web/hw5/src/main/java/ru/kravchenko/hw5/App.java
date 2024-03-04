package ru.kravchenko.hw5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * - Создайте сервис, который хранит продукты клиентов.
 * - Хранение продуктов необходимо организовать как в прошлом домашнем задании (пока не подключаем стартеры для работы с БД).
 * - Продукт клиента: id, номер счета, баланс, тип продукта (счет, карта).
 * - Сервис должен хранить продукты.
 * - Сервис должен давать возможность: запросить все продукты по userId, запросить продукт по productId.
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
