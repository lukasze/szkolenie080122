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

    Hobbit findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT h FROM Hobbit h WHERE h.firstName=:firstName AND h.lastName=:lastName ")
    Hobbit findHobbitUsingQuery(String firstName, String lastName);

    @Query(
            nativeQuery = true,
            value = "select * from hobbits where hobbits.first_name = :firstName and hobbits.last_name = :lastName")
    Hobbit findHobbitUsingNativeQuery(String firstName, String lastName);

    List<Hobbit> findUsingNamedQuery(String firstName, String lastName);
}