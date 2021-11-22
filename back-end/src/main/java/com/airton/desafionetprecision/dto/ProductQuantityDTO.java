package com.airton.desafionetprecision.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityDTO {

    private Long id;

    private Integer quantity;

    private BigDecimal price;

}
