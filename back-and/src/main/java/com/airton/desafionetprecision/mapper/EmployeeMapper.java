package com.airton.desafionetprecision.mapper;

import com.airton.desafionetprecision.dto.EmployeeDTO;
import com.airton.desafionetprecision.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee emp);

    Employee toEntity(EmployeeDTO dto);

    List<EmployeeDTO> toListDTO(List<Employee> listEntity);

    List<Employee> toListEntity(List<EmployeeDTO> listEntity);

}
