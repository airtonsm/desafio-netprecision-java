package com.airton.desafionetprecision.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public BigDecimal calcTotal(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
