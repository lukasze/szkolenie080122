package com.example.hobbitron.hobbit;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hobbits")
public class Hobbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
}
