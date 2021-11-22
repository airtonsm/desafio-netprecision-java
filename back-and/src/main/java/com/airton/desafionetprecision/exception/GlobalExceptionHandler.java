package com.airton.desafionetprecision.exception;

import com.airton.desafionetprecision.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDTO> sqlExceptionHandle(SQLException e, HttpServletRequest request){
        String error = "Error na integridade dos dados";
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorDTO err =  ErrorDTO.builder().status(status.value()).error(error).message(e.getMessage()).path(request.getRequestURI()).build();
        return ResponseEntity.status(status).body(err);
    }

}
