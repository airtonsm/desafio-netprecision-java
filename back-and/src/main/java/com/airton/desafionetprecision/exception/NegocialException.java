package com.airton.desafionetprecision.exception;

import org.springframework.http.HttpStatus;

public class NegocialException extends RuntimeException{


    private HttpStatus status;

    public NegocialException (HttpStatus status, String msg){
        super(msg);
        this.status = status;
    }
}
