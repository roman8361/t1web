package ru.kravchenko.paymentservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

class AppTests {
    @Test
    void contextLoads() {
        boolean b = Stream.of("a1", "d1", "c1")
                .map(it -> {
                    System.out.println("map: " + it);
                    return it.toUpperCase();
                })
                .anyMatch(it -> {
                    System.out.println("any: " + it);
                    return it.startsWith("D");
                });
    }

}
