package com.airton.desafionetprecision.mapper;

import com.airton.desafionetprecision.dto.LoginDTO;
import com.airton.desafionetprecision.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginMapper {

    LoginMapper INSTANCE = Mappers.getMapper(LoginMapper.class);

    LoginDTO toDTO(Employee entity);

    Employee toEntity(LoginDTO dto);

}
