package com.example.hobbitron.hobbit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;


@DataJpaTest
class HobbitRepositoryTest {

    @Autowired
    private HobbitRepository hobbitRepository;

    @Test
    void shouldFindFrodo_usingInheritedRepoMethod(){
        String firstName = "Frodo";
        String lastName = "Baggins";

        Hobbit hobbit = hobbitRepository.findByFirstNameAndLastName("Frodo", "Baggins");

        Assertions.assertEquals(firstName, hobbit.getFirstName());
        Assertions.assertEquals(lastName,hobbit.getLastName());
    }

    @Test
    void shouldFindFrodo_usingQuery(){
        String firstName = "Frodo";
        String lastName = "Baggins";

        Hobbit hobbit = hobbitRepository.findHobbitUsingQuery(firstName, lastName);

        Assertions.assertEquals(firstName, hobbit.getFirstName());
        Assertions.assertEquals(lastName, hobbit.getLastName());
    }

    @Test
    void shouldFindFrodo_usingNativeQuery(){
        String firstName = "Frodo";
        String lastName = "Baggins";

        Hobbit hobbit = hobbitRepository.findHobbitUsingNativeQuery(firstName, lastName);

        Assertions.assertEquals(firstName, hobbit.getFirstName());
        Assertions.assertEquals(lastName, hobbit.getLastName());
    }

    @Test
    void shouldFindFrodo_usingNamedQuery(){
        String firstName = "Frodo";
        String lastName = "Baggins";

        List<Hobbit> hobbitsFound = hobbitRepository.findUsingNamedQuery(firstName, lastName);

        Assertions.assertEquals(firstName, hobbitsFound.get(0).getFirstName());
        Assertions.assertEquals(lastName, hobbitsFound.get(0).getLastName());
    }

    @Test
    void shouldFindFrodo_usingCustomRepo(){
        String firstName = "Frodo";
        String lastName = "Baggins";

        List<Hobbit> hobbitsFound = hobbitRepository.findUsingCustomRepo(firstName, lastName);

        Assertions.assertEquals(firstName, hobbitsFound.get(0).getFirstName());
        Assertions.assertEquals(lastName, hobbitsFound.get(0).getLastName());
    }
}