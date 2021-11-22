package com.airton.desafionetprecision.config;

import com.airton.desafionetprecision.dto.LoginDTO;
import com.airton.desafionetprecision.entities.Employee;
import com.airton.desafionetprecision.exception.NegocialException;
import com.airton.desafionetprecision.mapper.LoginMapper;
import com.airton.desafionetprecision.repositories.EmployeeRepository;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8000")
public class HomeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Gson  gson = new Gson();

    @RequestMapping("login")
    @GetMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) throws NegocialException {
        Optional<Employee> optionalEmployee = employeeRepository.findByLogin(dto.getLogin());

        if(optionalEmployee.isPresent() && optionalEmployee.get().getPassword().equals(dto.getPassword())){
           return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson("Login efetuado com sucesso!!!"));

        }else if (optionalEmployee.isPresent() && !optionalEmployee.get().getPassword().equals(dto.getPassword())){
            throw new NegocialException(HttpStatus.UNAUTHORIZED, "Senha incorreta, tente novamente!");

        }else{
            throw new NegocialException(HttpStatus.UNAUTHORIZED, "Login não encontrado");
        }

    }

    @RequestMapping("/home")
    public void index(){

    }

}
