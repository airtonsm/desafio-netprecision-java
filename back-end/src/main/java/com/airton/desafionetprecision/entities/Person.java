package com.airton.desafionetprecision.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name = "email")
    private String email;

    @Column(unique = true, name = "cpf")
    private String cpf;

}
