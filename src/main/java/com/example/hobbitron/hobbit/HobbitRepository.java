package com.example.hobbitron.hobbit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
    Spring Data, możliwości:
    - rozszerzamy istniejący interfejs
    - definiujemy metody (nazwa generuje JPQL)
    - @Query
    - @Query (native)
    - @NamedQuery
    - @NamedNativeQuery
    - własna implementacja repozytorium
 */
public interface HobbitRepository extends JpaRepository<Hobbit, Long>, CustomHobbitRepository {

    /*
        Nazwa metody nie jest trywialna - na jej podstawie, Spring Data wygeneruje zapytanie
        https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
     */
    Hobbit findByFirstNameAndLastName(String firstName, String lastName);
    /*
        JPQL: Hobbit to nazwa encji, nie tabeli!
        Jeśli używamy @Query, nazwa metody nie ma zanczenia dla generowanego zapytania
     */
    @Query("SELECT h FROM Hobbit h WHERE h.firstName=:firstName AND h.lastName=:lastName ")
    Hobbit findHobbitUsingQuery(String firstName, String lastName);

    @Query(
            nativeQuery = true,
            // SQL - hobbits to nazwa tabeli
            value = "select * from hobbits where hobbits.first_name = :firstName and hobbits.last_name = :lastName")
    Hobbit findHobbitUsingNativeQuery(String firstName, String lastName);

    // findUsingNamedQuery: zapytanie zdefiniowane w encji Hobbit (@NamedQuery)
    List<Hobbit> findUsingNamedQuery(String firstName, String lastName);
}