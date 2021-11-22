package com.airton.desafionetprecision.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private LocalDateTime localDateTime;
    private Integer status;
    private String error;
    private String message;
    private String path;



    public void setLocalDateTime(LocalDateTime local){
        this.localDateTime = local;
    }

    public LocalDateTime getLocalDateTime(){
        return this.localDateTime;
    }

}
