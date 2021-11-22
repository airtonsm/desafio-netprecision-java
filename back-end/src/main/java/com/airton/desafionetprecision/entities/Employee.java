package com.airton.desafionetprecision.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_employee")
public  class Employee extends Person{

    @Column(unique = true, name = "login")
    private String login;

    @Column(name = "password")
    private String password;

}
