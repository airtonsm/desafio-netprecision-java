package com.airton.desafionetprecision.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String login;
    private String password;

}
