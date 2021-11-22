package com.airton.desafionetprecision.dto;

import com.airton.desafionetprecision.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private Long id;
    private LocalDateTime moment;
    private Integer productQuantity = 0;
    private BigDecimal subTotal;

    private List<ProductDTO> products = new ArrayList<>();

    public void calcPrice(){
        this.subTotal = new BigDecimal("0.0");
        for(ProductDTO productDTO : this.products){
            this.subTotal = this.subTotal.add(productDTO.calcTotal());
        }
    }

}
