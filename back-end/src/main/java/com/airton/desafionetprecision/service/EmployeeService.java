package com.airton.desafionetprecision.service;

import com.airton.desafionetprecision.dto.EmployeeDTO;
import com.airton.desafionetprecision.entities.Employee;
import com.airton.desafionetprecision.exception.GlobalExceptionHandler;
import com.airton.desafionetprecision.mapper.EmployeeMapper;
import com.airton.desafionetprecision.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDTO save( EmployeeDTO employeeDTO) {
        Employee emp = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        return EmployeeMapper.INSTANCE.toDTO(repository.save(emp));
    }

    public List<EmployeeDTO> findAll(){
        List<Employee> list = repository.findAll();
        return EmployeeMapper.INSTANCE.toListDTO(list);
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        return (UserDetails) repository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com esse login."));
    }


}
