package com.airton.desafionetprecision.resource;

import com.airton.desafionetprecision.dto.EmployeeDTO;
import com.airton.desafionetprecision.exception.GlobalExceptionHandler;
import com.airton.desafionetprecision.service.EmployeeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@CrossOrigin(origins = "http://localhost:8000")
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO) throws GlobalExceptionHandler {

        EmployeeDTO saveDTO = service.save(employeeDTO);
        if(saveDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(saveDTO);
        }else{
            throw new GlobalExceptionHandler();
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> listDto = service.findAll();
        return ResponseEntity.ok().body(listDto);

    }

}
