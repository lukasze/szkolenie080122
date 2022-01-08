package com.example.hobbitron.hobbit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
// Spring - użyj cały kontekst Spring'a do testów
@SpringBootTest
class HobbitControllerTest {

    // JUnit - metoda testowa
    @Test
    @DisplayName("GET /hobbits -> HTTP 200, lista 3 hobbitów")
    void findAll() {
        // nie trolujemy koleżanek / kolegów z zespołu
        fail();

        // given: endpoint /hobbits & 3 hobbits in DB

        // when: GET /hobbits

        // then: HTTP 200, 3 hobbits
    }
}