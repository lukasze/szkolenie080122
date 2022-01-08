package com.example.hobbitron.hobbit;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hobbits")
@NamedQuery(name = "Hobbit.findUsingNamedQuery", query = "select h from Hobbit h where h.firstName = :firstName and h.lastName = :lastName")
public class Hobbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
}